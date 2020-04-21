//package com.sdq.bigdata.kafka;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.UUID;
//
///**
// * Author:   chenfeiliang
// * Description:
// */
//@Component
//public class KfkaProducer {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//
//    //发送消息方法
//    public  void send() {
//        for(int i=0;i<5;i++){
////            Message message = new Message();
////            message.setId(System.currentTimeMillis());
////            message.setMsg(UUID.randomUUID().toString()+ "---" +i);
////            message.setSendTime(new Date());
//
//            kafkaTemplate.send("cfl", "cfl"+UUID.randomUUID().toString()+ "---" +i);
//            System.out.println("send-------"+"cfl"+UUID.randomUUID().toString()+ "---" +i);
//        }
//    }
//
//
//}
