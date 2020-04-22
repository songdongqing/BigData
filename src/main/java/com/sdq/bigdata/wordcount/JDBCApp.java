package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class JDBCApp {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        Job job = Job.getInstance(conf);

        // 设置job的各种属性
        job.setJobName("MySQLApp"); // 设置job名称
        job.setJarByClass(JDBCApp.class); // 设置搜索类
        job.setInputFormatClass(DBInputFormat.class); //read

        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://101.37.82.136:3306/bigdata";
        String userName = "root";
        String passWord = "@Chen4444";
        // 设置数据库配置
        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url,
                userName, passWord);

        // 设置数据输入内容-sql查询数据作为输入数据
        DBInputFormat.setInput(job, Position.class,
                "select * from position",
                "select count(*) from position");

        // 设置输出路径-输出一个结果文件到本地
        Path path = new Path("C:\\Users\\L\\Desktop\\result");
        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(path)) {
            fs.delete(path, true);
        }

        FileOutputFormat.setOutputPath(job, path);
        //把结果写入到数据表中对应字段
        //DBOutputFormat.setOutput(job,"xieru","word","count");

        job.setMapperClass(JDBCMapper.class); // 设置mapper类
        job.setReducerClass(JDBCReducer.class); // 设置reduecer类

        job.setMapOutputKeyClass(Text.class); // 设置之map输出key
        job.setMapOutputValueClass(IntWritable.class); // 设置map输出value
        job.setOutputKeyClass(Text.class); // 设置reduce 输出key
        job.setOutputValueClass(IntWritable.class); // 设置reduce输出value

        job.setNumReduceTasks(1);
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}
