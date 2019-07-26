package com.shineon.coder.service.mq.service;

import com.shineon.coder.service.mq.client.MataoMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MataoMessageClient.class)
public class MataoMessageService {
	Logger logger = LoggerFactory.getLogger(MataoMessageService.class);
	@StreamListener(MataoMessageClient.INPUTNAME)
	public void receive(String message)
	{
		logger.info("收到消息，请处理："+message);
	}

}
