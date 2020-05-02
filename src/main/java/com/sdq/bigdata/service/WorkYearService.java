package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.constant.SalaryEnum;
import com.sdq.bigdata.constant.WorkYearEnum;
import com.sdq.bigdata.entity.Salary;
import com.sdq.bigdata.entity.WorkYear;
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
public class WorkYearService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (WorkYearEnum workYearEnum : WorkYearEnum.values()) {
            WorkYear workYear = new WorkYear();
            //根据表名和行键获取对应的值
            workYear.setWorkYear(workYearEnum.getKey());
            int num = HbaseClient.getRow("workYear", workYearEnum.getKey());
            workYear.setNum(num);
            list.add(workYear);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListByCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (WorkYearEnum workYearEnum : WorkYearEnum.values()) {
            int num = 0;
            WorkYear workYear = new WorkYear();
            for (PositionEnum positionEnum : PositionEnum.values()) {
                workYear.setWorkYear(workYearEnum.getKey());
                workYear.setCity(city);
                num = num + HbaseClient.getRowQualifier("workYear", workYearEnum.getKey(), "info", city + "_" + positionEnum.getName());

            }
            workYear.setNum(num);
            list.add(workYear);
        }
        return list;
    }

    public List<Object> getListByPosition(String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (WorkYearEnum workYearEnum : WorkYearEnum.values()) {
            int num = 0;
            WorkYear workYear = new WorkYear();
            for (CityEnum cityEnum : CityEnum.values()) {
                workYear.setWorkYear(workYearEnum.getKey());
                workYear.setPosition(position);
                num = num + HbaseClient.getRowQualifier("workYear", workYearEnum.getKey(), "info", cityEnum.getName() + "_" + position);

            }
            workYear.setNum(num);
            list.add(workYear);
        }
        return list;
    }

    public List<Object> getListByPositionAndCity(String city,String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (WorkYearEnum workYearEnum : WorkYearEnum.values()) {
            WorkYear workYear = new WorkYear();
            workYear.setWorkYear(workYearEnum.getKey());
            workYear.setCity(city);
            workYear.setPosition(position);
            workYear.setNum(HbaseClient.getRowQualifier("workYear", workYearEnum.getKey(), "info", city+ "_" + position));
            list.add(workYear);
        }
        return list;
    }
}