package com.analyze.controller;

import com.analyze.entity.Url;
import com.analyze.repository.UrlRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hod on 05.09.18.
 */
@RestController
public class UrlController {

    private final UrlRepository urlRepository;

    UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @GetMapping("/urls")
    List<Url> all() {
        return urlRepository.findAll();
    }

    @PostMapping("/urls")
    Url newUrl(@RequestBody Url newUrl) {
        return urlRepository.save(newUrl);
    }

    @GetMapping("/urls/{id}")
    Url oneUrl(@PathVariable Long id) {

        return urlRepository.findById(id).get();
    }

    @PutMapping("/urls/{id}")
    Url replaceUrl(@RequestBody Url newUrl, @PathVariable Long id) {
        return urlRepository.findById(id)
                .map(url -> {
                    url.setUrl(newUrl.getUrl());
                    return urlRepository.save(url);
                }).orElseGet(() -> {
                    newUrl.setId(id);
                    return urlRepository.save(newUrl);
                });
    }

}
