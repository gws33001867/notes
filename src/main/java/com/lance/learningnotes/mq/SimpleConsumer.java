package com.lance.learningnotes.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author shanganwei
 */
@Slf4j
@Component
public class SimpleConsumer {


    /**
     * simple
     * @param message
     */
//    @RabbitListener(queuesToDeclare = @Queue("simpleQueue"))
//    public void process(String message){
//        log.info("SimpleCustomer Message: {}", message);
//    }
//
//    @RabbitListener(queuesToDeclare = @Queue("workQueue"))
//    public void process2(String message){
//        log.info("WorkQueueCustomerA Message: {}", message);
//    }
//
//    @RabbitListener(queuesToDeclare = @Queue("workQueue"))
//    public void process3(String message){
//        log.info("WorkQueueCustomerB Message: {}", message);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("sub1"), exchange = @Exchange(value = "AExchange", type = ExchangeTypes.FANOUT)))
//    public void process4(String message){
//        log.info("subCustomer1 Message: {}", message);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("sub2"), exchange = @Exchange(value = "BExchange", type = ExchangeTypes.FANOUT)))
//    public void process5(String message){
//        log.info("subCustomer2 Message: {}", message);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("sub3"), exchange = @Exchange(value = "BExchange", type = ExchangeTypes.FANOUT)))
//    public void process6(String message){
//        log.info("subCustomer3 Message: {}", message);
//    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("routingQueueOne"), key = "routingQueueOne",exchange = @Exchange(value = "CExchange")))
    public void process7(String message){
        log.info("1 Message: {}", message);
    }

//    @RabbitListener(bindings = @QueueBinding(value = @Queue("routingQueueTwo"), key = "routingQueueTwo1",exchange = @Exchange(value = "CExchange")))
//    public void process8(String message){
//        log.info("2 Message: {}", message);
//    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("routingQueueTwo"), key = {"routingQueueOne","routingQueueTwo"},exchange = @Exchange(value = "CExchange")))
    public void process9(String message){
        log.info("2 Message: {}", message);
    }
}
