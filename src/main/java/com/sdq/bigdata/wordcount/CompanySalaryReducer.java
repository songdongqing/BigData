package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class CompanySalaryReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Context context)
            throws IOException, InterruptedException {

        //上市公司_广州_数据分析  1
        String[] split = key.toString().split("_");
        String financeStage = split[0];
        String city = split[1];


        int sum = 0;
        for (IntWritable i : values) {
            sum +=i.get();
        }
        //设置word为Row Key 构建 Put对象
        //RowKey
        Put put = new Put(financeStage.getBytes());
        //指定插入到哪个列族，插入的列名和值
        put.add("info".getBytes(), city.getBytes(), (sum+"").getBytes());

        context.write(null, put);
    }


}