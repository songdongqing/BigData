package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.CompanySizeService;
import com.sdq.bigdata.service.SalaryService;
import com.sdq.bigdata.vo.GetCompanySizeVo;
import com.sdq.bigdata.vo.GetSalaryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Slf4j
@Controller
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @RequestMapping("/salary")
    @ResponseBody
    @CrossOrigin
    public ResResult getSalary(@RequestBody GetSalaryVo getSalaryVo) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if (Objects.isNull(getSalaryVo) || (StringUtils.isBlank(getSalaryVo.getCity()) && StringUtils.isBlank(getSalaryVo.getPosition()))) {
                list = salaryService.getList();
            } else {
                if (StringUtils.isBlank(getSalaryVo.getCity())) {
                    list = salaryService.getListByPosition(getSalaryVo.getPosition());
                } else if (StringUtils.isBlank(getSalaryVo.getPosition())) {
                    list = salaryService.getListByCity(getSalaryVo.getCity());
                } else {
                    list = salaryService.getListByPositionAndCity(getSalaryVo.getCity(), getSalaryVo.getPosition());
                }
            }
            return ResResult.success(list);
        } catch (Exception e) {
            log.info("getSalary error ={}", e);
        }
        return ResResult.fail("获取工资分布失败");
    }
}