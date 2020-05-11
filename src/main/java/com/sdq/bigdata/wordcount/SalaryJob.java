package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import com.sdq.bigdata.hbase.HbaseClient;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SalaryJob implements Runnable{

    public  void analyse() {
        log.info("开始分析工资情况");

        try {
            HbaseClient.truncateTable("salary");

            Configuration conf = new Configuration();
            conf.set("hbase.zookeeper.quorum", "hadoop");
            conf.set("hbase.zookeeper.property.clientPort", "2181");

            Job job = Job.getInstance(conf);
            job.setJarByClass(SalaryJob.class);
            job.setJobName("SalaryJob");

            job.setMapperClass(SalaryMapper.class);
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
            TableMapReduceUtil.initTableReducerJob("salary", SalaryReducer.class, job);
            System.out.println(job.waitForCompletion(true));
            log.info("完成分析工资情况");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        analyse();
    }
}