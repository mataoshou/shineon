package com.shineon.coder.service.mq.client ;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import com.shineon.coder.service.mq.BaseMessage;

public interface MataoMessageClient extends BaseMessage {
	String  INPUTNAME = "MataoMessageInput";
	@Input(INPUTNAME)
	@Override
	SubscribableChannel input();
	String  OUTPUTNAME = "MataoMessageOutput";
	@Output(OUTPUTNAME)
	@Override
	MessageChannel output();

}
