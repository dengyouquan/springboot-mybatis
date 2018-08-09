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
public interface BaseService<T extends BaseEntity> {
    void save(T t);

    void update(T t);

    void deleteById(Short id);

    T getById(Short id);

    List<T> getAll(T t);

    List<T> getAll(Short pageSize, Short pageNum);
}
