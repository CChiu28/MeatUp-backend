package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpBusiness extends BusinessResource {
    private Categories[] categories;
    private String[] photos;
    private Hours[] hours;
    private OpenHours[] special_hours;
}
