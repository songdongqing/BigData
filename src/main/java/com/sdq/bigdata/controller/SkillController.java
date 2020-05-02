package com.sdq.bigdata.controller;

import com.sdq.bigdata.dto.GetSkillDto;
import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.IndustryFieldService;
import com.sdq.bigdata.service.SkillService;
import com.sdq.bigdata.vo.GetSkillVo;
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
@Api(value = "职位要求分析相关接口",description = "职位要求分析相关接口")
@Slf4j
@Controller
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/skill")
    @ResponseBody
    @CrossOrigin
    @ApiOperation("获取职位要求数据")
    public ResResult getSkill(@RequestBody GetSkillVo getSkillVo) throws IOException {
        try {
            List<Object> list = new ArrayList<>();
            list = skillService.getList();
            return ResResult.success(list);
        } catch (Exception e) {
            log.info("getSalary error ={}", e);
        }
        return ResResult.fail("获取职位要求失败");
    }
}