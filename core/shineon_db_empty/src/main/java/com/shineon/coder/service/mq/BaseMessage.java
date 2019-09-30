package com.shineon.coder.service.mq;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BaseMessage {
	 SubscribableChannel input();
	 MessageChannel output();

}
