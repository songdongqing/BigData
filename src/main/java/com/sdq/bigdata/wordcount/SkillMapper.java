package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class SkillMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {


        //职位要求
        String city = value.getCity();
        String position = value.getAggregatePositionIdsStr();
        String skillLables = value.getSkillLablesStr();

        //职位要求可为空，要进行处理
        if(StringUtils.isBlank(skillLables)){
            skillLables = "无";
        }

        if(skillLables.contains(","))
        {
            String[] split = skillLables.split(",");
            for (String s : split){
                String key1 = s+"_"+city+"_"+position;
                k.set(key1);
                System.out.println("Mapper:"+key1);
                context.write(k,v);
            }
        }else {
            String key1 = skillLables+"_"+city+"_"+position;
            k.set(key1);
            System.out.println("Mapper:"+key1);
            context.write(k,v);
        }

    }
}