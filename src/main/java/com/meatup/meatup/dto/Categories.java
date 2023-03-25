package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories {
    private String alias;
    private String title;
    private String[] parent_aliases;
}
