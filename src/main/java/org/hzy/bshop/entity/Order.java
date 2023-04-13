package org.hzy.bshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;

    private String orderNumber;

    private Date createTime;

    private Double totalPrice;

    private Integer status;

    private Boolean isDeleted;

    private Integer userId;

    private Integer addressId;

    private String nickName;

}