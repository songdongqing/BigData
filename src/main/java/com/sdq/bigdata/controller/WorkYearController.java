package com.sdq.bigdata.controller;

import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.SalaryService;
import com.sdq.bigdata.service.WorkYearService;
import com.sdq.bigdata.vo.GetSalaryVo;
import com.sdq.bigdata.vo.GetWorkYearVo;
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
public class WorkYearController {

    @Autowired
    WorkYearService workYearService;

    @RequestMapping("/workYear")
    @ResponseBody
    @CrossOrigin
    public ResResult getWorkYear(@RequestBody GetWorkYearVo getWorkYearVo) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            if (Objects.isNull(getWorkYearVo) || (StringUtils.isBlank(getWorkYearVo.getCity()) && StringUtils.isBlank(getWorkYearVo.getPosition()))) {
                list = workYearService.getList();
            } else {
                if (StringUtils.isBlank(getWorkYearVo.getCity())) {
                    list = workYearService.getListByPosition(getWorkYearVo.getPosition());
                } else if (StringUtils.isBlank(getWorkYearVo.getPosition())) {
                    list = workYearService.getListByCity(getWorkYearVo.getCity());
                } else {
                    list = workYearService.getListByPositionAndCity(getWorkYearVo.getCity(), getWorkYearVo.getPosition());
                }
            }
            return ResResult.success(list);
        } catch (Exception e) {
            log.info("getSalary error ={}", e);
        }
        return ResResult.fail("获取工资分布失败");
    }
}