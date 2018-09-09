package com.analyze.controller;

import com.analyze.domain.Url;
import com.analyze.repository.UrlRepository;
import com.analyze.service.PageConsuption;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/go")
    public void go() throws IOException {
        //String url = "https://allegro.pl/kategoria/seria-5-f10-2009-2017-87995?stan=u%C5%BCywane&rodzaj-paliwa=Diesel&nadwozie=Kombi&order=m";
        String url = "https://allegro.pl/kategoria/przyczepy-naczepy-przyczepy-18530?stan=u%C5%BCywane&marka=Elddis&typ=kempingowa&order=m";
        System.out.println("DDDUUUPPPAAAA");
        PageConsuption pageConsuption = new PageConsuption();
        pageConsuption.loadDocument(url);
        System.out.println("DDDUUUPPPAAAA222222222");
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
