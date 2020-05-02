package com.sdq.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.sdq.bigdata.entity.Job;
import com.sdq.bigdata.entity.Position;
import com.sdq.bigdata.entity.Result;
import com.sdq.bigdata.mapper.PositionMapper;
import com.sdq.bigdata.test.Test;
import com.sdq.bigdata.util.CommUtil;
import com.sdq.bigdata.util.UuidUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@Api(value = "test",description = "测试相关接口")
public class HelloWorldController {

//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "cfl";
//    }
    @Autowired
    PositionMapper positionMapper;

    @ResponseBody
    @GetMapping("/hello2")
    public String sendMsg(){
        List<Result> results  = Test.getDatas();
        List<Position> positions = new ArrayList<>();
        results.forEach(result -> {
            Position position = new Position();
            BeanUtils.copyProperties(result,position);
            position.setId(UuidUtil.getUUID32());

            position.setAggregatePositionIdsStr(CommUtil.listToStr(result.getAggregatePositionIds()));
            position.setBusinessZonesStr(CommUtil.listToStr(result.getBusinessZones()));
            position.setCompanyLabelListStr(CommUtil.listToStr(result.getCompanyLabelList()));
            position.setIndustryLablesStr(CommUtil.listToStr(result.getIndustryLables()));
            position.setPositionLablesStr(CommUtil.listToStr(result.getPositionLables()));
            position.setSkillLablesStr(CommUtil.listToStr(result.getSkillLables()));
            positions.add(position);
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                positionMapper.insertList(positions);
            }
        }).start();

//        for(Result result:results){
//            kafkaTemplate.send("cfl", JSON.toJSONString(result));
//        }
//        System.out.println("发送数据");
        return "success";
    }


    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello,47..";
    }

}