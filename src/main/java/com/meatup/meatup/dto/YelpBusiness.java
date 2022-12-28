package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpBusiness {
    private String id;
    private String name;
    private String image_url;
    private String display_phone;
    private int review_count;
    private Categories[] categories;
    private float rating;
    private Location location;
    private String[] photos;
    private Hours[] hours;
    private String[] transactions;
    private OpenHours[] special_hours;
}
