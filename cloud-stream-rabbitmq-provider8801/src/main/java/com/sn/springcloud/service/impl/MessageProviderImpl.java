package com.sn.springcloud.service.impl;

import com.sn.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/20 14:25
 * @Description: EnableBinding 配合消息源 消息从这里发出 即 定义消息的推送管道
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    /**
     * 获取消息发送管道
     */
    @Resource(name = "output")
    private MessageChannel outputMessage;

    @Override
    public String send() {

        String message = "发送的消息：" + System.currentTimeMillis();

        //使用消息发送管道发送消息
        outputMessage.send(MessageBuilder.withPayload(message).build());

        return message;
    }
}