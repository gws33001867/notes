package com.lance.learningnotes;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author shanganwei
 */
@Slf4j
@SpringBootTest
public class MQTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * simple
     */
    @Test
    public void send() {
        amqpTemplate.convertAndSend("simpleQueue", "This is a simpleQueue's massage");
    }

    @Test
    public void send2() {
        while(true) {
            try {
                amqpTemplate.convertAndSend("workQueue", "This is a simpleQueue's massage");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void send3() throws InterruptedException {
        for (int i = 0; i <= 20; i++) {
            if(i % 2 == 0){
                amqpTemplate.convertAndSend("AExchange", "", "hello" + i);
            }else{
                amqpTemplate.convertAndSend("BExchange", "", "hello" + i);
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
    @Test
    public void send4() {
        for (int i = 0; i <= 20; i++) {
//            if(i % 2 == 0){
//                amqpTemplate.convertAndSend("CExchange", "routingQueueTwo1", "hello" + i);
//            }else{
//                amqpTemplate.convertAndSend("CExchange", "routingQueueTwo2", "hello" + i);
//            }
            log.info("i={}", i);
            synchronized (this){
                amqpTemplate.convertAndSend("CExchange", "routingQueueTwo", "hello" + i);

            }
        }
    }
}
