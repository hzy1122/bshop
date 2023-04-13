package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    private Integer racketId;
    private Integer badmintonId;
    private Integer count;
    private Double itemPrice;
    private Integer orderId;
    private Racket racket;
    private Badminton badminton;
}