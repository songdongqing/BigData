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
public class CompanySizeMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {

        //广州_数据分析_1000  1
        String companySize = value.getCompanySize();
        String city = value.getCity();
        String key1 = companySize+"_"+city;
        k.set(key1);

        context.write(k,v); //text(string)  int
    }

}