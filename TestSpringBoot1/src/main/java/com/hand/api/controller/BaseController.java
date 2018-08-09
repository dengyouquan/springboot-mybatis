package com.hand.api.controller;

import com.hand.api.service.BaseService;
import com.hand.domain.entity.BaseEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 20:07
 **/
public abstract class BaseController<V extends BaseEntity, T extends BaseService> {
    protected final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    protected T service;

    public abstract Class getEntityClass();

    @PostMapping
    public V save(@RequestBody V v) {
        v.setLastUpdate(new Date());
        service.save(v);
        logger.info("save " + getEntityClass().getSimpleName() + ":" + v);
        return v;
    }

    @PutMapping("/{id}")
    public V update(@PathVariable("id") Short id, @RequestBody V v) {
        System.out.println(v);
        v.setLastUpdate(new Date());
        service.update(v);
        logger.info("update " + getEntityClass().getSimpleName() + v);
        return v;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short id) {
        service.deleteById(id);
        logger.info("delete " +getEntityClass().getSimpleName() + ":" + id);
    }

    @GetMapping("/{id}")
    public V get(@PathVariable("id") Short id) {
        logger.info("get " + getEntityClass().getSimpleName() + ":" + id);
        return (V) service.getById(id);
    }

    @GetMapping
    public List<V> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "1") Short pageSize
            , @RequestParam(value = "pageNum", required = false, defaultValue = "10") Short pageNum) {
        logger.info("getAll " + getEntityClass().getSimpleName() + " pageSize:" + pageSize + ",pageNum:" + pageNum);
        return service.getAll(pageSize, pageNum);
    }
}
