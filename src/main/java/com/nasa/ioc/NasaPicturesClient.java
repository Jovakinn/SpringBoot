package com.nasa.ioc;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
@Slf4j
public class NasaPicturesClient {
    private final RestTemplate restTemplate;
    public List<String> getAllPictureUrl() {
        log.info("Calling NASA...");
        String nasaAPILink = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
        var json = restTemplate.getForObject(nasaAPILink, JsonNode.class);
        assert json != null;
        json.get("photos")
                .forEach(p -> log.info(p.get("img_src").asText()));
        return StreamSupport.stream(json.get("photos").spliterator(), false)
                .map(p -> p.get("img_src"))
                .map(JsonNode::asText)
                .collect(toList());
    }
}
