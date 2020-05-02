package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.CompanySizeService;
import com.sdq.bigdata.service.SalaryService;
import com.sdq.bigdata.vo.GetCompanySizeVo;
import com.sdq.bigdata.vo.GetSalaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "薪资情况分析相关接口",description = "薪资情况分析相关接口")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @PostMapping("/salary")
    @ResponseBody
    @CrossOrigin
    @ApiOperation("获取薪资情况数据")
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