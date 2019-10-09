package com.shineon.coder.service.mq.service ;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.cloud.stream.annotation.EnableBinding;import org.springframework.cloud.stream.annotation.StreamListener;import org.springframework.stereotype.Component;import com.shineon.coder.service.mq.client.Matao1MessageClient;@Component@EnableBinding(Matao1MessageClient.class)public class Matao1MessageService {	Logger logger = LoggerFactory.getLogger(Matao1MessageService.class);	@StreamListener(Matao1MessageClient.INPUTNAME)	public void receive(String message)	{		logger.info("收到消息，请处理："+message);	}}