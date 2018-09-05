package com.analyze.controller;

import com.analyze.entity.Url;
import com.analyze.repository.UrlRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/urls2")
    List<Url> all() {
        return urlRepository.findAll();
    }

    @GetMapping("/urls/{id}")
    Url oneUrl(@PathVariable Long id) {
        return urlRepository.findById(id).get();
    }
}
