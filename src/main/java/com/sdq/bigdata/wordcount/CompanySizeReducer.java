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
public class CompanySizeReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Context context)
            throws IOException, InterruptedException {

        //广州_数据分析_1000  1
        String[] split = key.toString().split("_");
        String city = split[1];
        String companySize = split[0];


        int sum = 0;
        for (IntWritable i : values) {
            sum +=i.get();
        }

        //RowKey
        Put put = new Put(companySize.getBytes());
        //指定插入到哪个列族，插入的列名和值
        put.add("info".getBytes(), city.getBytes(), (sum+"").getBytes());

        context.write(null, put);
    }
}