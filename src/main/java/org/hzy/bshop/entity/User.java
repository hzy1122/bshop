package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String nickName;

    private String account;

    private String password;

    private String phone;

    private String email;

    private Double balance;

    private Boolean isDeleted;

    private Cart cart;
}