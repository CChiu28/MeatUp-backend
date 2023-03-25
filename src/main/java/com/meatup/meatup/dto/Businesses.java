package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Businesses extends BusinessResource {
    @JsonProperty("is_closed")
    private boolean is_closed;
    private String url;
    private Coordinates coordinates;
    private String price;
    private Double distance;

}
