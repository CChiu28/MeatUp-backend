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
    public YelpSearchResult Search(@RequestBody SearchInput input) {
        System.out.println(input);
        return yelpService.getSearchResults(input);
    }

    @PostMapping(value = "/business")
    public YelpBusiness Business(@RequestBody String id) {
        return yelpService.getBusiness(id);
    }

    @PostMapping(value = "/reviews")
    public void Reviews(@RequestBody String id) {

    }
}
