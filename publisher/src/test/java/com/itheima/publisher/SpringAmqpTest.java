package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testAmqpTest(){
        //队列名称
        String queueName="simple.queue";
        //发送的消息
        String message="hello-world!!";
        //发送消息
        rabbitTemplate.convertAndSend(queueName,message);
    }

    @Test
    public void testWorkQueue() throws InterruptedException {
        // 队列名称
        String queueName = "work.queue";
        // 消息
        String message = "hello, message_";
        for (int i = 0; i < 50; i++) {
            // 发送消息，每20毫秒发送一次，相当于每秒发送50条消息
            rabbitTemplate.convertAndSend(queueName, message + i);
        }
    }
}