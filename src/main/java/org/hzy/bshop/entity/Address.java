package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class Address {
    private Integer id;
    private String province;
    private String city;
    private String area;
    private String information;
    private Boolean status;
    private Integer userId;
}