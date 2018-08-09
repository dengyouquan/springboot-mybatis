package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.CountryService;
import com.hand.domain.entity.Country;
import com.hand.infra.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, CountryMapper> implements CountryService {
    public List<Country> getAll(String country, Short pageSize, Short pageNum) {
        if (pageSize != null && pageNum != null) {
            PageHelper.startPage(pageSize, pageNum);
        }
        Weekend<Country> weekend = Weekend.of(Country.class);
        WeekendCriteria<Country, Object> criteria = weekend.weekendCriteria();
        if (!country.equals("")) {
            criteria.andLike("country", country);
        }
        return mapper.selectAll();
    }

    @Override
    public Country findByIdWithCity(Short countryId) {
        return mapper.findById(countryId);
    }
}
