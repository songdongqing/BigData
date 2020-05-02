package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.IndustryFieldEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.dto.GetSkillDto;
import com.sdq.bigdata.entity.IndustryField;
import com.sdq.bigdata.hbase.HbaseClient;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class SkillService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (PositionEnum positionEnum : PositionEnum.values()) {
            Map<String,Integer> results = HbaseClient.getRowLike("skill",positionEnum.getName());
            GetSkillDto getSkillDto = new GetSkillDto();
            getSkillDto.setPosition(positionEnum.getName());
            getSkillDto.setSkillMap(results);
            list.add(getSkillDto);
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