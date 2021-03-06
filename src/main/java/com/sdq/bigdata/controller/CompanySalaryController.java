package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.CompanySalary;
import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.CompanySalaryService;
import com.sdq.bigdata.service.SampleService;
import com.sdq.bigdata.vo.GetCompanySalaryVo;
import com.sdq.bigdata.vo.GetSampleVo;
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
@Api(value = "公司融资情况分析相关接口",description = "公司融资情况分析相关接口")
@Slf4j
@Controller
public class CompanySalaryController {

//    @Autowired


    @Autowired
    CompanySalaryService companySalaryService;

    @PostMapping("/companySalary")
    @ResponseBody
    @CrossOrigin
    @ApiOperation("获取公司融资情况数据")
    public ResResult getCompanySalary(@RequestBody GetCompanySalaryVo getCompanySalaryVo ) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if(Objects.isNull(getCompanySalaryVo)|| StringUtils.isBlank(getCompanySalaryVo.getCity())){
                list = companySalaryService.getList();
            }else {
                list = companySalaryService.getListWithCity(getCompanySalaryVo.getCity());
            }
            return ResResult.success(list);
        }catch (Exception e){
            log.info("getSample error ={}",e);
        }
        return ResResult.fail("获取样本数量失败");
    }
}