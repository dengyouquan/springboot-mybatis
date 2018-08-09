package com.hand.api.controller;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 15:26
 **/
@RestController
@RequestMapping("/api/films")
public class FilmController extends BaseController<Film, FilmService> {


    @Autowired
    private FilmService filmService;

    @Override
    public Class getEntityClass() {
        return Film.class;
    }

    @GetMapping("/{id}/actors")
    public Film findByIdWithFilm(@PathVariable("id") Short filmId) {
        return filmService.findByIdWithActor(filmId);
    }
}
