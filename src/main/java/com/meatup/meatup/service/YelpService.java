package com.meatup.meatup.service;

import com.meatup.meatup.dto.YelpBusiness;
import com.meatup.meatup.dto.YelpSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YelpService {
    private final String YELP_KEY;

    public YelpService(@Value("${YELP_API_KEY}") String yelp_key) {
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

    public YelpSearchResult getSearchResults(String location, String search) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/search?location="+location+"&term="+search+"&categories=&sort_by=best_match";
        ResponseEntity<YelpSearchResult> res = restTemplate.getForEntity(url, YelpSearchResult.class);
        return res.getBody();
    }

    public YelpBusiness getBusiness(String id) {
        System.out.println(id);
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.yelp.com/v3/businesses/"+id;
        ResponseEntity<YelpBusiness> res = restTemplate.getForEntity(url, YelpBusiness.class);
        return res.getBody();
    }
}
