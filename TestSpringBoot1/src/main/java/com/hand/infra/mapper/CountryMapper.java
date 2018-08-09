package com.hand.infra.mapper;

import com.hand.domain.entity.Country;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface CountryMapper extends Mapper<Country> {
    Country findById(Short countryId);
}