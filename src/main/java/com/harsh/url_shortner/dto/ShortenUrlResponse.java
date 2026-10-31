package com.harsh.url_shortner.dto;

public class ShortenUrlResponse {
    private String shortCode;
    private String shortUrl;

    public ShortenUrlResponse(String shortCode, String shortUrl) {
        this.shortCode = shortCode;
        this.shortUrl = shortUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getShortUrl() {
        return shortUrl;
}}
