package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviews {
    private int total;
    private Review[] reviews;
}
