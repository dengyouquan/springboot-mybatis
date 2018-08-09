package com.hand.infra.mapper;

import com.hand.domain.entity.Actor;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface ActorMapper extends Mapper<Actor> {
    Actor findById(Short actorId);
}