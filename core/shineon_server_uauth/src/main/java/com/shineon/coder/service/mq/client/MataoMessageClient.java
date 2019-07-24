package com.shineon.coder.service.mq.client;

import com.shineon.coder.service.mq.BaseMessage;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

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
