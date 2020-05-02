package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.CompanySizeEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.constant.SalaryEnum;
import com.sdq.bigdata.entity.CompanySize;
import com.sdq.bigdata.entity.Salary;
import com.sdq.bigdata.hbase.HbaseClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class SalaryService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (SalaryEnum salaryEnum : SalaryEnum.values()) {
            Salary salary = new Salary();
            //根据表名和行键获取对应的值
            salary.setSalary(salaryEnum.getKey());
            int num = HbaseClient.getRow("salary", salaryEnum.getKey());
            salary.setNum(num);
            list.add(salary);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListByCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (SalaryEnum salaryEnum : SalaryEnum.values()) {
            int num = 0;
            Salary salary = new Salary();
            for (PositionEnum positionEnum : PositionEnum.values()) {
                salary.setSalary(salaryEnum.getKey());
                salary.setCity(city);
                num = num + HbaseClient.getRowQualifier("salary", salaryEnum.getKey(), "info", city + "_" + positionEnum.getName());

            }
            salary.setNum(num);
            list.add(salary);
        }
        return list;
    }

    public List<Object> getListByPosition(String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (SalaryEnum salaryEnum : SalaryEnum.values()) {
            int num = 0;
            Salary salary = new Salary();
            for (CityEnum cityEnum : CityEnum.values()) {
                salary.setSalary(salaryEnum.getKey());
                salary.setCity(cityEnum.getName());
                num = num + HbaseClient.getRowQualifier("salary", salaryEnum.getKey(), "info", cityEnum.getName() + "_" + position);

            }
            salary.setNum(num);
            list.add(salary);
        }
        return list;
    }

    public List<Object> getListByPositionAndCity(String city,String position) throws IOException {
        List<Object> list = new ArrayList<>();
        for (SalaryEnum salaryEnum : SalaryEnum.values()) {
                Salary salary = new Salary();
                salary.setSalary(salaryEnum.getKey());
                salary.setCity(city);
                salary.setPosition(position);
                salary.setNum(HbaseClient.getRowQualifier("salary", salaryEnum.getKey(), "info", city+ "_" + position));
                list.add(salary);
        }
        return list;
    }
}