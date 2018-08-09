package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.BaseService;
import com.hand.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 14:31
 **/
@Transactional
//泛型继承后为何要指定边界？？？
public class BaseServiceImpl<K extends BaseEntity, T extends Mapper> implements BaseService<K> {
    @Autowired
    protected T mapper;

    @Override
    public void save(K k) {
        mapper.insert(k);
    }

    @Override
    public void update(K k) {
        mapper.updateByPrimaryKey(k);
    }

    @Override
    public void deleteById(Short id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public K getById(Short id) {
        return (K) mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<K> getAll(K k) {
        if (k.getPage() != null && k.getRows() != null) {
            PageHelper.startPage(k.getPage(), k.getRows());
        }
        return mapper.selectAll();
    }

    @Override
    public List<K> getAll(Short pageSize, Short pageNum) {
        if (pageSize != null && pageNum != null) {
            PageHelper.startPage(pageSize, pageNum);
        }
        return mapper.selectAll();
    }
}
