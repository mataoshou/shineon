package com.shineon.coder.service.mq.service ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import com.shineon.coder.service.mq.client.Matao2MessageClient;

@Component
@EnableBinding(Matao2MessageClient.class)
public class Matao2MessageService {
	Logger logger = LoggerFactory.getLogger(Matao2MessageService.class);
	@StreamListener(Matao2MessageClient.INPUTNAME)
	public void receive(String message)
	{
		logger.info("收到消息，请处理："+message);
	}

}
