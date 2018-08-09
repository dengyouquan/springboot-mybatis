package com.hand.api.controller;

import com.hand.api.service.ActorService;
import com.hand.api.service.FilmService;
import com.hand.domain.entity.Actor;
import com.hand.domain.entity.Country;
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
@RequestMapping("/api/actors")
public class ActorController extends BaseController<Actor,ActorService> {

    @Autowired
    private ActorService actorService;

    @GetMapping("/{id}/films")
    public Actor findByIdWithFilm(@PathVariable("id") Short actorId){
        return actorService.findByIdWithFilm(actorId);
    }

    @Override
    public Class getEntityClass() {
        return Actor.class;
    }
}
