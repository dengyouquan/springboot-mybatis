package com.hand.api.service;

import com.hand.domain.entity.Film;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
public interface FilmService extends BaseService<Film> {
    Film findByIdWithActor(Short filmId);
}
