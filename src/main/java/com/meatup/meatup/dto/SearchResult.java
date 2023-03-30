package com.meatup.meatup.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SearchResult {
    private int total;
    private Region region;
}
