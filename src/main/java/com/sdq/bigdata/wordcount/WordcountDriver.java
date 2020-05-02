package com.sdq.bigdata.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordcountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        long startTime = System.currentTimeMillis();
        args=new String[]{"E:\\input","E:\\output"};

        //输出路径若存在则会报错，Hadoop默认是本地路径，但是若在core-site.xml配置了就会变为集群路径
//        args = new String[] {"/opt/module/data/input.txt", "/opt/module/data/output" };
//        if(args.length < 2){
//            System.out.println("系统参数不正确，请按照指定格式传递: java -jar Produce.jar path1 path2 ");
//            System.exit(1);
//        }

        /*
         * 功能描述: 如何执行本程序
         * java -cp hadoop.jar com.atguigu.mapreduce.WordcountDriver /data.txt /output
         * 打成out包，然后在集群中启动hadoop，然后路径为hdfs上的路径
         *
         *
         * @param:   [args]
         * @return : void
         * @author : chenfeiliang
         */
        // 1 获取配置信息以及封装任务
        Configuration configuration = new Configuration();
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        Job job = Job.getInstance(configuration);

        // 2 设置jar加载路径
        job.setJarByClass(WordcountDriver.class);

        // 3 设置map和reduce类
        job.setMapperClass(WordcountMapper.class);
        job.setReducerClass(WordcountReducer.class);

        // 4 设置map输出
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 设置最终输出kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 6 设置输入和输出路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 7 提交
          boolean result = job.waitForCompletion(true);
        System.out.println("统计单词完毕！");

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        System.exit(result ? 0 : 1);
    }
}