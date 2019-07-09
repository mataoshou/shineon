package com.shineon.coder.stream.mclinet;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

public interface UserMqClient {

    final String  INPUT = "userinput";
    final String  OUTPUT = "useroutput";


    @Input(INPUT)
    SubscribableChannel input();

//    @Output(OUTPUT)
//    MessageChannel output();
}
