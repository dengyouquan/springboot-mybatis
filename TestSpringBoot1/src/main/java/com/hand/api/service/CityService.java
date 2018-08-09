package com.hand.api.service;

import com.hand.domain.entity.BaseEntity;
import com.hand.domain.entity.City;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
public interface CityService extends BaseService<City> {
    City findByIdWithCountry(Short cityId);
}
