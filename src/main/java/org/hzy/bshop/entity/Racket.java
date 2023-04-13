package org.hzy.bshop.entity;

import lombok.Data;

@Data
public class Racket {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Double appraise;

    private Integer stock;

    private String imagePath;

    private Integer brandId;

    private Integer seriesId;

    private Integer handleId;

    private Integer weightId;

    private Integer placeId;

    private Boolean isDeteled;

    private Weight weight;
    private Handle handle;
    private Place place;
    private Brand brand;
    private Series series;

    public String getShortDesc(){
        if(description.length()>10){
            return description.substring(0,10)+"...";
        }else{
            return description;
        }
    }
}