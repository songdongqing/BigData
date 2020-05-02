package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.IndustryFieldEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.constant.SalaryEnum;
import com.sdq.bigdata.entity.IndustryField;
import com.sdq.bigdata.entity.Salary;
import com.sdq.bigdata.hbase.HbaseClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class IndustryFieldService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (IndustryFieldEnum industryFieldEnum : IndustryFieldEnum.values()) {
            IndustryField industryField = new IndustryField();
            //根据表名和行键获取对应的值
            industryField.setIndustryField(industryFieldEnum.getKey());
            int num = HbaseClient.getRow("industryField", industryFieldEnum.getKey());
            industryField.setNum(num);
            list.add(industryField);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListByCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (IndustryFieldEnum industryFieldEnum : IndustryFieldEnum.values()) {
            int num = 0;
            IndustryField industryField = new IndustryField();
            for (PositionEnum positionEnum : PositionEnum.values()) {
                industryField.setIndustryField(industryFieldEnum.getKey());
                industryField.setCity(city);
                num = num + HbaseClient.getRowQualifier("industryField", industryFieldEnum.getKey(), "info", city + "_" + positionEnum.getName());

            }
            industryField.setNum(num);
            list.add(industryField);
        }
        return list;
    }

    public List<Object> getListByPosition(String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (IndustryFieldEnum industryFieldEnum : IndustryFieldEnum.values()) {
            int num = 0;
            IndustryField industryField = new IndustryField();
            for (CityEnum cityEnum : CityEnum.values()) {
                industryField.setIndustryField(industryFieldEnum.getKey());
                industryField.setCity(cityEnum.getName());
                num = num + HbaseClient.getRowQualifier("industryField", industryFieldEnum.getKey(), "info", cityEnum.getName() + "_" + position);

            }
            industryField.setNum(num);
            list.add(industryField);
        }
        return list;
    }

    public List<Object> getListByPositionAndCity(String city,String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (IndustryFieldEnum industryFieldEnum : IndustryFieldEnum.values()) {
            IndustryField industryField = new IndustryField();
            industryField.setIndustryField(industryFieldEnum.getKey());
            industryField.setCity(city);
            industryField.setPosition(position);
            industryField.setNum(HbaseClient.getRowQualifier("industryField", industryFieldEnum.getKey(), "info", city+ "_" + position));
            list.add(industryField);
        }
        return list;
    }
}