package com.shineon.coder.service.mq.service ;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.cloud.stream.annotation.EnableBinding;import org.springframework.cloud.stream.annotation.StreamListener;import org.springframework.stereotype.Component;import com.shineon.coder.service.mq.client.UserErrorMessageClient;@Component@EnableBinding(UserErrorMessageClient.class)public class UserErrorMessageService {	Logger logger = LoggerFactory.getLogger(UserErrorMessageService.class);	@StreamListener(UserErrorMessageClient.INPUTNAME)	public void receive(String message)	{		logger.info("收到error消息，请处理："+message);	}}