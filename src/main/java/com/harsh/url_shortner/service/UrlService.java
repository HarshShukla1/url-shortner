package com.harsh.url_shortner.service;

import com.harsh.url_shortner.entity.UrlMapping;
import com.harsh.url_shortner.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    private String generateShortCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        return  code.toString();
    }

    public UrlMapping shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();
        do{
            shortCode = generateShortCode();

        }while(urlRepository.existsByShortCode(shortCode));

        UrlMapping mapping = new UrlMapping();

        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(shortCode);

        return urlRepository.save(mapping);


    }
}
