package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.BaseService;
import com.hand.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
//无法再这里配置Cache，因为必须有一个value,相当于zset，然后每个实现实体类key会冲突
public abstract class BaseServiceImpl<K extends BaseEntity, T extends Mapper> implements BaseService<K> {

    @Autowired
    protected T mapper;

    @Override
    public K save(K k) throws Exception {
        mapper.insert(k);
        return (K) mapper.selectByPrimaryKey(k);
    }

    @Override
    public K update(K k) {
        mapper.updateByPrimaryKey(k);
        ////u对象中可能只有只几个有效字段，其他字段值靠数据库生成，比如id
        return (K) mapper.selectByPrimaryKey(k);
    }

    @Override
    public void deleteById(Short id) {
        mapper.deleteByPrimaryKey(id);
    }

    //@Cacheable(key = "#id.toString()")
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
