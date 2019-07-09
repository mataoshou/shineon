package com.shineon.coder.stream.mreceiver;


import com.shineon.coder.stream.mclinet.UserMqClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(UserMqClient.class)
public class UserReceiver {
//
    @StreamListener(UserMqClient.INPUT)
//    @SendTo(UserMqClient.OUTPUT)
    public void receive(String message)
    {
        System.out.println("11111....................."+message);
//        return " message from input ";
    }

//    @StreamListener(UserMqClient.OUTPUT)
////    @SendTo(UserMqClient.INPUT)
//    public void receiveOutput(String message)
//    {
//        System.out.println("22222....................."+message);
//
////        return " message from output ";
//    }
}
