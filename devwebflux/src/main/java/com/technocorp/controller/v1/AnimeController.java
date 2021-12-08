package com.technocorp.controller;

import com.technocorp.domain.Anime;
import com.technocorp.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/animes")
@CrossOrigin("*")
@Slf4j
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    public Flux<Anime> listAll(){
        return animeService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Anime> findById(@PathVariable("id") Integer id) {
        return animeService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Mono<Anime> findByName(@PathVariable("name") String name) throws Exception {
        return animeService.findByName(name);
    }
}
