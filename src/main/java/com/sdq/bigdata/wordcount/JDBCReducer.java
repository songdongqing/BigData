package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class JDBCReducer extends  TableReducer<Text, IntWritable, ImmutableBytesWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Context context)
            throws IOException, InterruptedException {

        //数据挖掘_深圳  450
        String[] split = key.toString().split("_");
        String position = split[0];
        String city = split[1];


        int sum = 0;
        for (IntWritable i : values) {
            sum +=i.get();
        }
        //设置word为Row Key 构建 Put对象
        //RowKey
        Put put = new Put(position.getBytes());
        //指定插入到哪个列族，插入的列名和值
        put.add("info".getBytes(), city.getBytes(), (sum+"").getBytes());

        context.write(null, put);
    }



////    IntWritable v = new IntWritable();
////    Text k = new Text();
//    private Put outputValue;
//
//    @Override
//    protected void reduce(Text key, Iterable<IntWritable> values,
//                          Context context) throws IOException, InterruptedException {
//        System.out.println(key.toString());
////        outputValue = new Put(Bytes.toBytes(key.toString()));
////        outputValue.addColumn(Bytes.toBytes("i"), Bytes.toBytes("age"), Bytes.toBytes(key.getCity()));
//        context.write(NullWritable.get(), outputValue);
//    }
//
////    @Override
////    protected void reduce(Text key,Iterable<IntWritable> values, Context context)
////            throws IOException, InterruptedException {
////
////        System.out.println("reduce");
////        int count = 0;
////        for (IntWritable value : values) {
////            count += value.get();
////        }
////        v.set(count);
////        context.write(key,v);
////    }
}
