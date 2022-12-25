package com.meatup.meatup.controller;

import com.meatup.meatup.DTO.Businesses;
import com.meatup.meatup.DTO.SearchInput;
import com.meatup.meatup.DTO.YelpBusiness;
import com.meatup.meatup.DTO.YelpSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class YelpController {
    private final String YELP_KEY;

    public YelpController(@Value("${YELP_API_KEY}") String yelp_key) {
        this.YELP_KEY = yelp_key;
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().setBearerAuth(YELP_KEY);
            return execution.execute(request,body);
        }));
        return restTemplate;
    }

    @PostMapping(value = "/search",consumes = {"application/json"})
    public YelpSearchResult Search(@RequestBody SearchInput input) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/search?location="+input.getLocation()+"&term="+input.getSearch()+"&categories=&sort_by=best_match";
        ResponseEntity<YelpSearchResult> res = restTemplate.getForEntity(url, YelpSearchResult.class);
        return res.getBody();
    }

    @PostMapping(value = "/business/{id}")
    public YelpBusiness Business(@PathVariable String id) {
        System.out.println(id);
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/"+id;
        ResponseEntity<YelpBusiness> res = restTemplate.getForEntity(url, YelpBusiness.class);
        return res.getBody();
    }

}
