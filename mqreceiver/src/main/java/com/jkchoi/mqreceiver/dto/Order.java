package com.jkchoi.mqreceiver.dto;


import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer OrderNo;
    private String OrderUser;
    private String OrderItem;
    private Integer OrderStatus;
    private String orderDate;

}
