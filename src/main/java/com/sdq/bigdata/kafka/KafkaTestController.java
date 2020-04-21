//package com.sdq.bigdata.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * Author:   chenfeiliang
// * Description:
// */
//@Controller
//public class KafkaTestController {
//
//    @Autowired
//    private KfkaProducer producer;
//
//    @RequestMapping("/testSendMsg")
//    @ResponseBody
//    public String testSendMsg(){
//        producer.send();
//        return "success";
//    }
//
//    @RequestMapping("/testSendMsg1")
//    @ResponseBody
//    public String testSendMsg1() {
//        return "success";
//    }
//
//
//}