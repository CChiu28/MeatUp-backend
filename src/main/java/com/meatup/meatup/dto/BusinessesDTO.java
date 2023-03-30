package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessesDTO extends BusinessResource {
    @JsonProperty("is_closed")
    private boolean is_closed;
    private String[] categories;
    private String url;
    private Coordinates coordinates;
    private String price;
}
