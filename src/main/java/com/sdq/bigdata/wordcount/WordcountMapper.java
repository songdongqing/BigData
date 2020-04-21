//package com.sdq.bigdata.wordcount;
//
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.InputSplit;
//import org.apache.hadoop.mapreduce.Mapper;
//
//import java.io.IOException;
//
//public class WordcountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
//
//    private int  count=0;
//    Text k = new Text();
//    IntWritable v = new IntWritable(1);
//
//    @Override
//    protected void setup(Context context) throws IOException, InterruptedException {
//        InputSplit inputSplit = context.getInputSplit();
////        inputSplit.
////        System.out.println(inputSplit);
////        System.out.println("-----------------------");
//
//    }
//
//    @Override
//    protected void map(LongWritable key, Text value, Context context)	throws IOException, InterruptedException {
//
//        //取得读取的行数
//        count = count + 1;
//
//        // 1 获取一行 sdq cfl
//        String line = value.toString();
//
//        // 2 切割
//        String[] words = line.split(" ");
//
//
//        // 3 输出
//        for (String word : words) {
//
//            k.set(word);
//            context.write(k, v);
//        }
//    }
//
////    @Override
////    protected void cleanup(Context context) throws IOException, InterruptedException{
////        //map清理资源的操作
////        //在reduce中把linescount取出来就行了
////        context.write(new Text("行数:"), new IntWritable(count));
////    }
//}