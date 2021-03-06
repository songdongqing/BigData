package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.Position;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class PositionMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        //这里传入的key是0，1...n
        // value是Position(id=fead07aba8504bf6826b08e7eb5e4492, lastLogin=null, education=null...),
        // 其值由sql语句和readFields共同确定

        String str = "";
        String positionName = value.getAggregatePositionIdsStr();
        for (PositionEnum position : PositionEnum.values()){
            if (positionName.contains(position.getName())){
                positionName = position.getName();
            }
        }

        String city = value.getCity();
        str = positionName+"_"+city;

        k.set(str);
        context.write(k,v); //text(string)  int
    }
}
