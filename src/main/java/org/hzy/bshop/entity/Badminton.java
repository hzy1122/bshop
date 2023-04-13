package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class Badminton {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String imagePath;

    private Integer brandId;

    private Integer seriesId;

    private Integer plumeId;

    private Integer speedId;

    private Boolean isDeteled;

    private Brand brand;
    private Series series;
    private Plume plume;
    private Speed speed;
}