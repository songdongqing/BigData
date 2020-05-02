package com.sdq.bigdata.controller;

import com.sdq.bigdata.dto.GetSkillDto;
import com.sdq.bigdata.entity.ResResult;
import com.sdq.bigdata.service.IndustryFieldService;
import com.sdq.bigdata.service.SkillService;
import com.sdq.bigdata.vo.GetSkillVo;
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
public class SkillController {

    @Autowired
    SkillService skillService;

    @RequestMapping("/skill")
    @ResponseBody
    @CrossOrigin
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