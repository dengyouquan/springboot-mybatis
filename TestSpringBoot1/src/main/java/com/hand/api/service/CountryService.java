package com.hand.api.service;

import com.hand.domain.entity.Country;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
public interface CountryService extends BaseService<Country> {
    List<Country> getAll(String country, Short pageSize, Short pageNum);
    Country findByIdWithCity(Short countryId);
}
