package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String originalUrl) {
        return urlService.shortenUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl("http://localhost:8080/" + shortUrl);
        if (originalUrl != null) {
            return "Redirecting to: " + originalUrl;
        } else {
            return "URL not found";
        }
    }
}
