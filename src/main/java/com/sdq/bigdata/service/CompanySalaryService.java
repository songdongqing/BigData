package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CompanySalaryEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.CompanySalary;
import com.sdq.bigdata.entity.Sample;
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
public class CompanySalaryService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (CompanySalaryEnum companySalaryEnum : CompanySalaryEnum.values()) {
            CompanySalary companySalary = new CompanySalary();
            //根据表名和行键获取对应的值
            companySalary.setCompanySalary(companySalaryEnum.getKey());
            int num = HbaseClient.getRow("companySalary", companySalaryEnum.getKey());
            companySalary.setNum(num);
            list.add(companySalary);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListWithCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (CompanySalaryEnum companySalaryEnum : CompanySalaryEnum.values()) {
            CompanySalary companySalary = new CompanySalary();
            //根据表名和行键获取对应的值
            companySalary.setCompanySalary(companySalaryEnum.getKey());
            companySalary.setCity(city);
            companySalary.setNum(HbaseClient.getRowQualifier("companySalary", companySalaryEnum.getKey(), "info", city));
            list.add(companySalary);

        }

        return list;
    }
}