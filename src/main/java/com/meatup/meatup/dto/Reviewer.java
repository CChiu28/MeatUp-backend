package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviewer {
    private String id;
    private String image_url;
    private String name;
}
