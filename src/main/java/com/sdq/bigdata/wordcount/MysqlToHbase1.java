package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class MysqlToHbase1 {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        // 设置job的各种属性
        job.setJobName("ggg"); // 设置job名称
        job.setJarByClass(MysqlToHbase1.class); // 设置搜索类
        job.setInputFormatClass(DBInputFormat.class); //read

        job.setMapperClass(MysqlToHBaseMapper.class);

        // 设置我们需要链接的数据库
        // 使用远程登录权限的用户,需要进行远程访问
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://101.37.82.136:3306/bigdata";
        String userName = "root";
        String passWord = "@Chen4444";
        // 设置数据库配置
        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url,
                userName, passWord);



        // 设置输出格式,添加数据到Hbase中
        TableMapReduceUtil.initTableReducerJob("bd:user", MysqlToHBaseReduce.class, job);
        job.setMapOutputKeyClass(Position.class);
        job.setMapOutputValueClass(NullWritable.class);
        // 设置输入格式为数据库:数据裤读取
        job.setInputFormatClass(DBInputFormat.class);
        // select filenames from tablename where condition orderby
//        DBInputFormat.setInput(job, Position.class, "position", null, "id", "id","name", "age");

        DBInputFormat.setInput(job, Position.class,
                "select * from position",
                "select count(*) from position");

        // 数据库操作必定要使用驱动,把jar上传到hdfs做成缓存文件,供每台机器使用
        // 否则就要上传jar到每一台机器
        //job.addFileToClassPath(new Path("hdfs://192.168.19.11:9000/mysql-connector-java-5.1.38.jar"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

    public static class MysqlToHBaseMapper extends Mapper<LongWritable, Position, Position, NullWritable> {

        @Override
        protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Position, NullWritable>.Context context)
                throws IOException, InterruptedException {
            context.write(value, NullWritable.get());
        }

    }

    //定义reducer对接输出到hbase
    //reduce的输入类型KEYIN, VALUEIN
    //reduce输出的key的类型KEYOUT，写入hbase中reduce的输出key并不重要，重要的是value，value的数据会被写入hbase表，key的数据不重要,
    //只需要保证reduce的输出value是put类型就可以了
    //create 'bd:user','i'
    public static class MysqlToHBaseReduce extends TableReducer<Position, NullWritable, NullWritable> {
        private Put outputValue;

        @Override
        protected void reduce(Position key, Iterable<NullWritable> value,
                              Reducer<Position, NullWritable, NullWritable, Mutation>.Context context)
                throws IOException, InterruptedException {
            outputValue = new Put(Bytes.toBytes(key.getId()));
            outputValue.addColumn(Bytes.toBytes("i"), Bytes.toBytes("age"), Bytes.toBytes(key.getCity()));
            context.write(NullWritable.get(), outputValue);
        }

    }


}