package com.hand.api.service.impl;

import com.hand.api.service.CityService;
import com.hand.domain.entity.City;
import com.hand.infra.mapper.CityMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
//@Transactional
@Service
//自定义Cache，不使用基类的Cache配置
@CacheConfig(cacheNames = "citys")//默认名字,已经下面覆盖
public class CityServiceImpl extends BaseServiceImpl<City,CityMapper> implements CityService {

    @Override
    public City findByIdWithCountry(Short cityId) {
        return mapper.findById(cityId);
    }

    // 必须要有返回值，否则没数据放到缓存中
    @CachePut(value = "city",key = "#city.cityId.toString()")
    @Override
    public City save(City city) throws Exception {
        return super.save(city);
    }

    @CachePut(value = "city",key = "#city.cityId.toString()")
    @Override
    public City update(City city) {
        return super.update(city);
    }

    @CacheEvict(value = "city",key = "#id.toString()")
    @Override
    public void deleteById(Short id) {
        super.deleteById(id);
    }

    @Cacheable(value = "city",key = "#id.toString()")
    @Override
    public City getById(Short id) {
        return super.getById(id);
    }

    //置分页key为负数，以便不与get cache id冲突
    @Cacheable(value = "city",key = "(-#pageSize).toString()")
    @Override
    public List<City> getAll(Short pageSize, Short pageNum) {
        return super.getAll(pageSize, pageNum);
    }
}
