package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class PositionJob {

    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();
        //hdfs 主nameNode通信地址
//        conf.set("fs.defaultFS", "hdfs://node01:8020");
        //yarn 主resourcemanager通信地址
//        conf.set("yarn.resourcemanager.hostname", "node02:8088");
        //zookeeper集群，连接到HMaster
//        conf.set("hbase.zookeeper.quorum", "node01,node02,node03");
//        conf.set("hbase.zookeeper.quorum", "192.168.19.11");
        conf.set("hbase.zookeeper.quorum", "hadoop");
        conf.set("hbase.zookeeper.property.clientPort", "2181");

        Job job = Job.getInstance(conf);
        job.setJarByClass(PositionJob.class);
        job.setJobName("PositionJob");

        job.setMapperClass(PositionMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
//        //hdfs文件存储路径
//        FileInputFormat.addInputPaths(job,"/data/input/wordcount.txt");

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

        //实现reduce结果输出到 HBase的哪个表
        TableMapReduceUtil.initTableReducerJob("position", PositionReducer.class, job);

        try {
            System.out.println(job.waitForCompletion(true));
        } catch (ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}