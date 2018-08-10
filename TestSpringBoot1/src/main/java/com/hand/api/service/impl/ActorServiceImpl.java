package com.hand.api.service.impl;

import com.hand.api.service.ActorService;
import com.hand.domain.entity.Actor;
import com.hand.infra.mapper.ActorMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
@CacheConfig(cacheNames = "actor")
@Service
public class ActorServiceImpl extends BaseServiceImpl<Actor,ActorMapper> implements ActorService {

    @Override
    public Actor findByIdWithFilm(Short actorId) {
        return mapper.findById(actorId);
    }
}
