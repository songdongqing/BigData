package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class WorkYearMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {

        //广州_数据分析_1000  1
        String workYear = value.getWorkYear();
        String city = value.getCity();
        String position = value.getAggregatePositionIdsStr();
        String key1 = workYear+"_"+city+"_"+position;
        k.set(key1);

        context.write(k,v); //text(string)  int
    }
}