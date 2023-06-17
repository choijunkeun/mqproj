package com.jkchoi.mqsender.module;


import com.jkchoi.mqsender.dto.Order;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
@AllArgsConstructor
public class SenderModule {

    final RabbitTemplate rabbitTemplate;

    // fixedDelay - 해당 작업이 끝난 시점부터 시간을 셈, fixedRate - 해당 작업의 시작 시점부터 시간을 셈
//    @Scheduled(fixedRate = 1000)
//    public void sender1() {
//
//        LocalDateTime nowDateTime = LocalDateTime.now();
//        String time = nowDateTime.toString();
//        System.out.println("Send :  " + time);
//        rabbitTemplate.convertAndSend("time", "time-first", time);
//    }


//    @Scheduled(fixedRate = 1000)
//    public void sender2() {
//        LocalDateTime nowDateTime = LocalDateTime.now();
//        String time = nowDateTime.toString();
//        Dept dept = new Dept(10, "test", "test", time);
//        System.out.println("1 Send :  " + dept.toString());
//        rabbitTemplate.convertAndSend("dept", "dept-first", dept);
//    }


    @Scheduled(fixedRate = 1000)
    public void sender3() {     // 주문 들어오면 mq에 sender해줌.
        for(int i=1; i<5000; i++) {
            Order order = new Order();
            LocalDateTime nowDateTime = LocalDateTime.now();
            String time = nowDateTime.toString();
            order.setOrderNo(i);
            order.setOrderUser("최준근" + i);
            order.setOrderItem("신라면" + i);
            order.setOrderStatus(i);
            order.setOrderDate(time);
            System.out.println("1. 주문 :  " + order.toString());
            rabbitTemplate.convertAndSend("order", "order-ramen", order);
        }

        for(int j=1; j<5000; j++) {
            Order order = new Order();
            LocalDateTime nowDateTime = LocalDateTime.now();
            String time = nowDateTime.toString();
            order.setOrderNo(j);
            order.setOrderUser("최준근" + j);
            order.setOrderItem("쿠키" + j);
            order.setOrderStatus(j);
            order.setOrderDate(time);
            System.out.println("1. 주문 :  " + order.toString());
            rabbitTemplate.convertAndSend("order", "order-cookie", order);
        }


    }
}
