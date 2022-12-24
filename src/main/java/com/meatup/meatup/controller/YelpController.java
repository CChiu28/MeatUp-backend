package com.meatup.meatup.controller;

import com.meatup.meatup.DTO.SearchInput;
import com.meatup.meatup.DTO.YelpBusiness;
import com.meatup.meatup.DTO.YelpSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
public class YelpController {

    private final String YELP_KEY;


    public YelpController(@Value("${YELP_API_KEY}") String yelp_key) {
        this.YELP_KEY = yelp_key;
    }

    @GetMapping("/test")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().setBearerAuth(YELP_KEY);
            return execution.execute(request,body);
        }));
        return restTemplate;
    }

    @PostMapping("/search")
    public YelpSearchResult Search(@RequestBody SearchInput input) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/search?location="+input.getLocation()+"&term="+input.getSearch()+"&categories=&sort_by=best_match&limit=30";
        ResponseEntity<YelpSearchResult> res = restTemplate.getForEntity(url, YelpSearchResult.class);
        return res.getBody();
    }

    @GetMapping("/business/{id}")
    public YelpBusiness Business(@PathVariable String id) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/"+id;
        ResponseEntity<YelpBusiness> res = restTemplate.getForEntity(url, YelpBusiness.class);
        return res.getBody();
    }

}
