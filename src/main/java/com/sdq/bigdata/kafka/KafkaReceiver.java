//package com.sdq.bigdata.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * Author:   chenfeiliang
// * Description:
// */
//@Component
//public class KafkaReceiver {
//
//  //  @KafkaListener(topics = {"cfl"})
//    @KafkaListener(topics = "cfl")
//    public void listen(String data) {
////        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
////        if (kafkaMessage.isPresent()) {
////            Object message = kafkaMessage.get();
////            System.out.println("get--------------"+message);
////        }
//        System.out.println("get--------------"+data);
//
//    }
//
//
//}