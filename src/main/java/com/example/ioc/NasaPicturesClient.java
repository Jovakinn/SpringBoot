package com.example.ioc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NasaPicturesClient {

    private final RestTemplate restTemplate;

    public List<String> getAllPictureUrl() {
        System.out.println("Calling NASA...");
        return Collections.emptyList();
    }
}
