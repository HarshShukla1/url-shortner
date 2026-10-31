package com.harsh.url_shortner.controller;

import com.harsh.url_shortner.dto.ShortenUrlRequest;
import com.harsh.url_shortner.dto.ShortenUrlResponse;
import com.harsh.url_shortner.entity.UrlMapping;
import com.harsh.url_shortner.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @PostMapping("/shorten")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(
            @Valid @RequestBody ShortenUrlRequest shortenUrlRequest
    ){
        UrlMapping mapping = urlService.shortenUrl(shortenUrlRequest.getOriginalUrl());

        String shortUrl =
                "http://localhost:8080/" + mapping.getShortCode();

        ShortenUrlResponse response =
                new ShortenUrlResponse(
                        mapping.getShortCode(),
                        shortUrl
                );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
