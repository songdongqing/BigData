package com.sdq.bigdata.wordcount;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class SalaryReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Context context)
            throws IOException, InterruptedException {

        //15-30k广州_数据分析  420
        String[] split = key.toString().split("_");
        String city = split[1];
        String position = split[2];
        String salary = split[0];
        String key1 = city+"_"+position;

        int sum = 0;
        for (IntWritable i : values) {
            sum +=i.get();
        }
        //设置word为Row Key 构建 Put对象
        //RowKey
        Put put = new Put(salary.getBytes());
        //指定插入到哪个列族，插入的列名和值
        put.add("info".getBytes(), key1.getBytes(), (sum+"").getBytes());

        context.write(null, put);
    }
}