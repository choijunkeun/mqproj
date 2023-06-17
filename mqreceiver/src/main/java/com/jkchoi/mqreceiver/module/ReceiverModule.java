package com.jkchoi.mqreceiver.module;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ReceiverModule {
//
//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange(name = "time", type = ExchangeTypes.TOPIC),
//            value = @Queue(name = "time-second"),
//            key = "time-first"
//    ))
//    public void receiver(String msg) {
//        System.out.println("Receive : " + msg);
//    }
//
//
//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange(name = "dept", type = ExchangeTypes.TOPIC),
//            value = @Queue(name = "dept-second"),
//            key = "dept-first"
//    ))
//    @SendTo("dept/dept-third")
//    public Dept receiver2(Dept dept) {
//        System.out.println("2 Receive : " + dept.toString());
//
//        Dept dept1 = new Dept(20, "new", "new", "");
//
//        System.out.println("3 ReSend : " + dept1.toString());
//
//        return dept1;
//    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "order", type = ExchangeTypes.TOPIC),
            value = @Queue(name = "order-ramen"),
            key = "order-ramen"
    ))
    public void receiver3(Order order) {
        System.out.println("2. 라면 주문 받음 : " + order);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "order", type = ExchangeTypes.TOPIC),
            value = @Queue(name = "order-cookie"),
            key = "order-cookie"
    ))
    public void receiver4(Order order) {
        System.out.println("2. 쿠키 주문 받음 : " + order);
    }



}
