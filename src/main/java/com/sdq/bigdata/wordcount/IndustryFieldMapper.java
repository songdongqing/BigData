package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.entity.Position;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class IndustryFieldMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {
        try {
            String city = value.getCity();
            String position = value.getAggregatePositionIdsStr();
            String industryField = value.getIndustryField();
            industryField = industryField.replaceAll(" ",",");
            industryField = industryField.replaceAll("、",",");
            industryField = industryField.replaceAll("丨","");


//            String a = value.getIndustryField()+"_"+city+"_"+position;
//            System.out.println("a:   "+a);
            //职位要求
            if((!StringUtils.isBlank(industryField))&&
                    (industryField.contains(",")))
            {
                String[] split = industryField.split(",");
                for (String s : split){
                    String key1 = s+"_"+city+"_"+position;
                    k.set(key1);
                    context.write(k,v);
                }
            }else {
                String key1 = industryField+"_"+city+"_"+position;
                k.set(key1);

                context.write(k,v);
            }
        }catch (Exception e){

            e.printStackTrace();
        }



    }
}