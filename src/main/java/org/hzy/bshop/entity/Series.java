package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class Series {

    private Integer id;

    private String name;

    private Integer brandId;

    private Boolean isDeleted;

    private Brand brand;
}