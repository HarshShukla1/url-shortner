package com.harsh.url_shortner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ShortenUrlRequest {
    @NotBlank(message = "URL cannot be empty")
    @Size(max = 2048, message = "URL is too long")
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
}}
