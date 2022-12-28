package com.meatup.meatup.controller;

import com.meatup.meatup.dto.SearchInput;
import com.meatup.meatup.dto.YelpBusiness;
import com.meatup.meatup.dto.YelpSearchResult;
import com.meatup.meatup.service.YelpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class YelpController {
    private YelpService yelpService;

    @PostMapping(value = "/search",consumes = {"application/json"})
    public YelpSearchResult Search(@RequestBody SearchInput input) {
        return yelpService.getSearchResults(input.getLocation(), input.getSearch());
    }

    @PostMapping(value = "/business")
    public YelpBusiness Business(@RequestBody String id) {
        return yelpService.getBusiness(id);
    }

}
