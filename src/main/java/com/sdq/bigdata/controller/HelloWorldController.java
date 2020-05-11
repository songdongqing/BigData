package com.sdq.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.sdq.bigdata.dto.JobResult;
import com.sdq.bigdata.entity.Position;
import com.sdq.bigdata.entity.Result;
import com.sdq.bigdata.mapper.PositionMapper;
import com.sdq.bigdata.strategy.JobContext;
import com.sdq.bigdata.strategy.LaGouStrategy;
import com.sdq.bigdata.util.CommUtil;
import com.sdq.bigdata.util.UuidUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

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