package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class CartItem {

    private Integer id;

    private Integer racketId;

    private Integer badmintonId;

    private Integer count;

    private Double itemPrice;

    private Integer cartId;

    private Racket racket;
    private Badminton badminton;

}