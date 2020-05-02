package com.sdq.bigdata.service;

import com.sdq.bigdata.constant.CompanySizeEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.CompanySize;
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
public class CompanySizeService {

    //根据表名和行键获取对应的值
    public List<Object> getList() throws IOException {

        List<Object> list = new ArrayList<>();

        for (CompanySizeEnum companySizeEnum : CompanySizeEnum.values()) {
            CompanySize companySize = new CompanySize();
            //根据表名和行键获取对应的值
            companySize.setCompanySize(companySizeEnum.getCompanySize());
            int num = HbaseClient.getRow("companySize", companySizeEnum.getCompanySize());
            companySize.setNum(num);
            list.add(companySize);
        }

        return list;
    }

    //获取某一行指定“列族:列”的数据
    public List<Object> getListWithCity(String city) throws IOException {
        List<Object> list = new ArrayList<>();
        for (CompanySizeEnum companySizeEnum : CompanySizeEnum.values()) {
            CompanySize companySize = new CompanySize();
            //根据表名和行键获取对应的值
            companySize.setCompanySize(companySizeEnum.getCompanySize());
            companySize.setCity(city);
            companySize.setNum(HbaseClient.getRowQualifier("companySize", companySizeEnum.getCompanySize(), "info", city));
            list.add(companySize);

        }

        return list;
    }
}