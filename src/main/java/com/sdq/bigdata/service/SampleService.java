package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.Sample;
import com.sdq.bigdata.hbase.HbaseClient;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:返回所需的数据给前端
 */
@Service
public class SampleService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (PositionEnum position : PositionEnum.values()) {
            Sample sample = new Sample();
            //根据表名和行键获取对应的值
            sample.setPositionName(position.getName());
            int num = HbaseClient.getRow("position", position.getName());
            sample.setNum(num);
            list.add(sample);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListWithCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (PositionEnum position : PositionEnum.values()) {
            Sample sample = new Sample();
            //根据表名和行键获取对应的值
            sample.setPositionName(position.getName());
            sample.setCity(city);
            sample.setNum(HbaseClient.getRowQualifier("position", position.getName(), "info", city));
            list.add(sample);

        }

        return list;
    }
}