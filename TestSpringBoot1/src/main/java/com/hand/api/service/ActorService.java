package com.hand.api.service;

import com.hand.domain.entity.Actor;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
public interface ActorService extends BaseService<Actor> {
    Actor findByIdWithFilm(Short actorId);
}
