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
public class FilmController {

    private static final Logger logger = Logger.getLogger(FilmController.class);

    @Autowired
    private FilmService filmService;

    @PostMapping
    public Film save(@RequestBody Film film) {
        System.out.println(film);
        film.setLastUpdate(new Date());
        filmService.save(film);
        logger.info("save film:" + film);
        return film;
    }

    @PutMapping("/{id}")
    public Film update(@PathVariable("id") Short filmId, @RequestBody Film film) {
        Film oldFilm = filmService.getById(filmId);
        film.setLastUpdate(new Date());
        film.setFilmId(oldFilm.getFilmId());
        filmService.update(film);
        logger.info("update oldFilm:" + oldFilm + " to " + film);
        return film;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short filmId) {
        filmService.deleteById(filmId);
        logger.info("delete city:" + filmId);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable("id") Short filmId) {
        logger.info("get film:" + filmId);
        return filmService.getById(filmId);
    }

    @GetMapping
    public List<Film> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "1") Short pageSize
            , @RequestParam(value = "pageNum", required = false, defaultValue = "10") Short pageNum) {
        logger.info("getAll film pageSize:" + pageSize + ",pageNum:" + pageNum);
        return filmService.getAll(pageSize, pageNum);
    }

    @GetMapping("/{id}/actors")
    public Film findByIdWithFilm(@PathVariable("id") Short filmId){
        return filmService.findByIdWithActor(filmId);
    }
}
