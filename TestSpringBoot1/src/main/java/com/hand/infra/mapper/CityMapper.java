package com.hand.infra.mapper;

import com.hand.domain.entity.City;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface CityMapper extends Mapper<City> {
    City findById(Short cityId);
}