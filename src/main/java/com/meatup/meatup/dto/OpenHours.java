package com.meatup.meatup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OpenHours {
    private String start;
    private String end;
    private String day;
    private String date;
    @JsonProperty("is_overnight")
    private boolean is_overnight;
    @JsonProperty("is_closed")
    private boolean is_closed;
}
