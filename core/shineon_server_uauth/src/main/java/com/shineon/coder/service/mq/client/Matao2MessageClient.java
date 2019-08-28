package com.shineon.coder.service.mq.client ;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import com.shineon.coder.service.mq.BaseMessage;

public interface Matao2MessageClient extends BaseMessage {
	String  INPUTNAME = "Matao2MessageInput";
	@Input(INPUTNAME)
	@Override
	SubscribableChannel input();
	String  OUTPUTNAME = "Matao2MessageOutput";
	@Output(OUTPUTNAME)
	@Override
	MessageChannel output();

}
