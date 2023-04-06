package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class BusinessesDTO extends BusinessResource {
    @JsonProperty("is_closed")
    private boolean is_closed;
    private ArrayList<String> categories;
    private String url;
    private Coordinates coordinates;
    private String price;
}
