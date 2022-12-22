package com.meatup.meatup.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Businesses {
    private String id;
    private String name;
    private String image_url;
    private boolean is_closed;
    private String url;
    private Categories[] categories;
    private float rating;
    private Coordinates coordinates;
    private String price;
    private Location location;
    private String display_phone;
    private Double distance;

}
