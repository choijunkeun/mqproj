package com.jkchoi.mqreceiver.module;


import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long OrderNo;
    private String OrderUser;
    private String OrderItem;
    private Date orderDate;

}
