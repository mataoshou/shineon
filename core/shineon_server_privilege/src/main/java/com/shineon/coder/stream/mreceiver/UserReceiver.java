package com.shineon.coder.stream.mreceiver;


import com.shineon.coder.stream.mclinet.UserMqClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(UserMqClient.class)
public class UserReceiver {

    @StreamListener(UserMqClient.INPUT)
    public void receive(Object obj)
    {
        System.out.println("11111....................."+obj);
    }

//    @StreamListener(UserMqClient.OUTPUT)
//    public void receiveOutput(String message)
//    {
//        System.out.println("22222....................."+message);
//    }
}
