package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.IndustryFieldService;
import com.sdq.bigdata.service.SalaryService;
import com.sdq.bigdata.vo.GetIndustryFieldVo;
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
@Api(value = "行业领域情况分析相关接口",description = "行业领域情况分析相关接口")
public class IndustryFieldController {

    @Autowired
    IndustryFieldService industryFieldService;

    @PostMapping("/industryField")
    @ResponseBody
    @CrossOrigin
    @ApiOperation("获取行业领域情况数据")
    public ResResult getIndustryField(@RequestBody GetIndustryFieldVo getIndustryFieldVo) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if (Objects.isNull(getIndustryFieldVo) || (StringUtils.isBlank(getIndustryFieldVo.getCity()) && StringUtils.isBlank(getIndustryFieldVo.getPosition()))) {
                list = industryFieldService.getList();
            } else {
                if (StringUtils.isBlank(getIndustryFieldVo.getCity())) {
                    list = industryFieldService.getListByPosition(getIndustryFieldVo.getPosition());
                } else if (StringUtils.isBlank(getIndustryFieldVo.getPosition())) {
                    list = industryFieldService.getListByCity(getIndustryFieldVo.getCity());
                } else {
                    list = industryFieldService.getListByPositionAndCity(getIndustryFieldVo.getCity(), getIndustryFieldVo.getPosition());
                }
            }
            return ResResult.success(list);
        } catch (Exception e) {
            log.info("getSalary error ={}", e);
        }
        return ResResult.fail("获取行业分布失败");
    }
}