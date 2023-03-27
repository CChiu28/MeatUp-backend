package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    private String id;
    private String url;
    private String text;
    private float rating;
    private String time_created;
    private Reviewer user;
}
