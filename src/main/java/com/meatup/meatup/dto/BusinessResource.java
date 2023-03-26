package com.meatup.meatup.dto;

import lombok.Getter;

@Getter
public abstract class BusinessResource {
    private String id;
    private String name;
    private String image_url;
    private String display_phone;
    private int review_count;
    private Categories[] categories;
    private float rating;
    private Location location;
    private String[] transactions;
    private Double distance;
}
