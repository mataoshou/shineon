//package com.shineon.coder.service.mq;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
///**
// * 出错的消息处理过程
// */
//@Service
//public class MessageError {
//    public void error(MessageItem item)
//    {
//
//    }
//
//
//
//    private static final String ORIGINAL_QUEUE = "so8400in.so8400";
//
//    private static final String DLQ = ORIGINAL_QUEUE + ".dlq";
//
//    private static final String PARKING_LOT = ORIGINAL_QUEUE + ".parkingLot";
//
//    private static final String X_RETRIES_HEADER = "x-retries";
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @RabbitListener(queues = DLQ)
//    public void rePublish(Message failedMessage) {
//        Integer retriesHeader = (Integer) failedMessage.getMessageProperties().getHeaders().get(X_RETRIES_HEADER);
//        if (retriesHeader == null) {
//            retriesHeader = Integer.valueOf(0);
//        }
//        if (retriesHeader < 3) {
//            failedMessage.getMessageProperties().getHeaders().put(X_RETRIES_HEADER, retriesHeader + 1);
//            this.rabbitTemplate.send(ORIGINAL_QUEUE, failedMessage);
//        }
//        else {
//            this.rabbitTemplate.send(PARKING_LOT, failedMessage);
//        }
//    }
//
//    @Bean
//    public Queue parkingLot() {
//        return new Queue(PARKING_LOT);
//    }
//
//}
