package com.sdq.bigdata.wordcount;

import com.sdq.bigdata.constant.SalaryEnum;
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
public class SalaryMapper extends Mapper<LongWritable, Position, Text, IntWritable> {

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Position value, Mapper<LongWritable, Position, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {


        //广州_数据分析_15-30k  1
        String salary = value.getSalary();
        String city = value.getCity();
        String position = value.getAggregatePositionIdsStr();

        salary = salary.toLowerCase();
        salary = salary.replaceAll("k","");

//        //对工资情况进行划分
        if(!StringUtils.isBlank(salary)&&salary.contains("-")){
            String[] split = salary.split("-");
            for (SalaryEnum salaryEnum : SalaryEnum.values()){

                if(salaryEnum.getMinVal() <= Integer.parseInt(split[0]) && salaryEnum.getMaxVal() >= Integer.parseInt(split[0])){
                    salary = salaryEnum.getKey();
                    break;
                }
            }
        }






        String key1 = salary+"_"+city+"_"+position;
        k.set(key1);

        context.write(k,v); //text(string)  int
    }

}