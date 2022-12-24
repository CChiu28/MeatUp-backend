package com.meatup.meatup.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hours {
    private OpenHours[] open;
    private String hours_type;
    @JsonProperty("is_open_now")
    private boolean is_open_now;
}
