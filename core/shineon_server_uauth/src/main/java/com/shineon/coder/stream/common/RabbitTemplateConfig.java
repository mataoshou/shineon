package com.shineon.coder.stream.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback {

    Logger logger = LoggerFactory.getLogger(RabbitTemplateConfig.class);

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init()
    {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.debug("消息唯一标识：" +correlationData);
        logger.debug("确认结果：" +correlationData);
        logger.debug("失败原因：" +correlationData);

    }
}
