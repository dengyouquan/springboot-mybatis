package com.hand.api.service.impl;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.stereotype.Service;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
@Service
public class FilmServiceImpl extends BaseServiceImpl<Film,FilmMapper> implements FilmService {

    @Override
    public Film findByIdWithActor(Short filmId) {
        return mapper.findById(filmId);
    }
}
