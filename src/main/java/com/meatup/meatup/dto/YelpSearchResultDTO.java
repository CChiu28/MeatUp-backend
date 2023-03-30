package com.meatup.meatup.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class YelpSearchResultDTO extends SearchResult{
    private ArrayList<BusinessesDTO> businesses;
}
