package com.sdq.bigdata.controller;

import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.entity.Sample;
import com.sdq.bigdata.service.SampleService;
import com.sdq.bigdata.vo.GetSampleVo;
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
 * Description: 样本情况分析
 */
@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @Autowired
    SampleService sampleService;

    @RequestMapping("/sum")
    @ResponseBody
    @CrossOrigin
    public ResResult getSample(@RequestBody GetSampleVo getSampleVo ) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if(Objects.isNull(getSampleVo)||StringUtils.isBlank(getSampleVo.getCity())){
                System.out.println(getSampleVo.getCity());
                list = sampleService.getList();
            }else {
                list = sampleService.getListWithCity(getSampleVo.getCity());
            }
            return ResResult.success(list);
        }catch (Exception e){
            log.info("getSample error ={}",e);
        }
        return ResResult.fail("获取样本数量失败");
    }
}