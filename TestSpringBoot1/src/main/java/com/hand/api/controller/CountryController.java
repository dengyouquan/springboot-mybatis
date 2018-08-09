package com.hand.api.controller;

import com.hand.api.service.CountryService;
import com.hand.domain.entity.Country;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 09:40
 **/
@RestController
@RequestMapping("/api/countrys")
public class CountryController extends BaseController<Country,CountryService> {

    @GetMapping("/weekend")
    public List<Country> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "1") Short pageSize
            , @RequestParam(value = "pageNum", required = false, defaultValue = "10") Short pageNum
            , @RequestParam(value = "country", required = false, defaultValue = "") Short country) {
        logger.info("getAll country pageSize:" + pageSize + ",pageNum:" + pageNum);
        return service.getAll("", pageSize, pageNum);
    }

    @GetMapping("/{id}/cities")
    public Country findByIdWithCity(@PathVariable("id") Short countryId){
        return service.findByIdWithCity(countryId);
    }

    @Override
    public Class getEntityClass() {
        return Country.class;
    }
}
