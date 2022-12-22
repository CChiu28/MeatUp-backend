package com.meatup.meatup.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class YelpSearchResult {
    private Businesses[] businesses;
    private int total;
    private Region region;
}
