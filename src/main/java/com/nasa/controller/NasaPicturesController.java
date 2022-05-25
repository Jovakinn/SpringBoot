package com.nasa.controller;

import com.nasa.ioc.NasaPicturesClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class NasaPicturesController {
    private final NasaPicturesClient nasaPicturesClient;
    private final HttpServletRequest httpServletRequest;

    @GetMapping
    public String getAllPicturesUrls() {
        var servletContext = httpServletRequest.getServletContext();
        servletContext.getAttributeNames().asIterator().forEachRemaining(log::info);
        return String.join("\n", nasaPicturesClient.getAllPictureUrl());
    }
}
