//package com.sdq.bigdata.wordcount;
//
//
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
//import org.apache.hadoop.hbase.mapreduce.TableMapper;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.net.TableMapping;
//
//import java.io.IOException;
//
///**
// * Author:   chenfeiliang
// * Description:
// */
//public class HbaseMapper extends TableMapper<Text, Text> {
//
//    @Override
//    protected void map(ImmutableBytesWritable key, Result value, Context context)
//            throws IOException, InterruptedException {
//        System.out.println("key"+key);
//        System.out.println("value"+value);
//    }
//}