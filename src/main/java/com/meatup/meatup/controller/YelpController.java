package com.meatup.meatup.controller;

import com.meatup.meatup.DTO.YelpSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class YelpController {

    private final String YELP_KEY;

    public YelpController(@Value("${YELP_API_KEY}") String yelp_key) {
        this.YELP_KEY = yelp_key;
    }

    @GetMapping("/test")
    public String test() {
        System.out.println(YELP_KEY);
        return YELP_KEY;
    }

    @GetMapping("/search")
    public YelpSearchResult Search() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().setBearerAuth(YELP_KEY);
            return execution.execute(request,body);
        }));
        String location = "nyc";
        String search = "ice cream";
        String url = "https://api.yelp.com/v3/businesses/search?location="+location+"&term="+search+"&categories=&sort_by=best_match&limit=30";
        ResponseEntity<YelpSearchResult> res = restTemplate.getForEntity(url, YelpSearchResult.class);
        return res.getBody();
    }

}
