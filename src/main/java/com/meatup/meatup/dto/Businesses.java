package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Businesses extends BusinessResource {
    @JsonProperty("is_closed")
    private boolean is_closed;
    private ArrayList<Categories> categories;
    private String url;
    private Coordinates coordinates;
    private String price;

}
