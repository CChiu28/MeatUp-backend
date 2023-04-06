package com.meatup.meatup.controller;

import com.meatup.meatup.dto.*;
import com.meatup.meatup.service.YelpService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173","https://meatup1028.netlify.app/"})
public class YelpController {
    private YelpService yelpService;
    private ModelMapper mapper;

    @PostMapping(value = "/search",consumes = {"application/json"})
    public YelpSearchResultDTO Search(@RequestBody SearchInput input) {
        System.out.println(input);
        YelpSearchResult res = yelpService.getSearchResults(input);
        return mapper.map(res, YelpSearchResultDTO.class);
    }

    @PostMapping(value = "/business")
    public YelpBusiness Business(@RequestBody String id) {
        return yelpService.getBusiness(id);
    }

    @PostMapping(value = "/reviews")
    public Reviews Reviews(@RequestBody String id) {
        return yelpService.getReviews(id);
    }
}
