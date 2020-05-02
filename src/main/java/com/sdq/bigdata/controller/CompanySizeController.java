package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.CompanySizeService;
import com.sdq.bigdata.vo.GetCompanySizeVo;
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
@Slf4j
@Controller
@Api(value = "公司规模分析相关接口",description = "公司规模分析相关接口")
public class CompanySizeController {

    @Autowired
    CompanySizeService companySizeService;

    @PostMapping("/companySize")
    @ResponseBody
    @CrossOrigin
    @ApiOperation("获取公司规模数据")
    public ResResult getCompanySize(@RequestBody GetCompanySizeVo getCompanySize ) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if(Objects.isNull(getCompanySize)|| StringUtils.isBlank(getCompanySize.getCity())){
                list = companySizeService.getList();
            }else {
                list = companySizeService.getListWithCity(getCompanySize.getCity());
            }
            return ResResult.success(list);
        }catch (Exception e){
            log.info("getSample error ={}",e);
        }
        return ResResult.fail("获取样本数量失败");
    }
}