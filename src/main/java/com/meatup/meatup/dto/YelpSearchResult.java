package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class YelpSearchResult {
    private ArrayList<Businesses> businesses;
    private int total;
    private Region region;
}
