package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.constant.PositionEnum;
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
public class CompanySalaryMapper extends Mapper <LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {

        //这里传入的key是0，1...n
        // value是Position(id=fead07aba8504bf6826b08e7eb5e4492, lastLogin=null, education=null...),
        // 其值由sql语句和readFields共同确定


        //上市公司_广州_数据分析  1
        String city = value.getCity();
        String financeStage = value.getFinanceStage();
        String key1 = financeStage+"_"+city;
        k.set(key1);

//        System.out.println("Mapper-key:"+key1);
        context.write(k,v); //text(string)  int
    }

}