package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private final String DOMAIN = "http://localhost:8080/";

    public String shortenUrl(String originalUrl) {
        Optional<Url> existingUrl = Optional.ofNullable(urlRepository.findByOriginalUrl(originalUrl));
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        } else {
            String shortUrl = DOMAIN + generateShortUrl();
            Url url = new Url();
            url.setOriginalUrl(originalUrl);
            url.setShortUrl(shortUrl);
            urlRepository.save(url);
            return shortUrl;
        }
    }

    public String getOriginalUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl);
        return url != null ? url.getOriginalUrl() : null;
    }

    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * characters.length());
            shortUrl.append(characters.charAt(index));
        }
        return shortUrl.toString();
    }
}
