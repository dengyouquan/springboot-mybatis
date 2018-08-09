package com.hand.api.controller;

import com.hand.api.service.CityService;
import com.hand.domain.entity.City;
import org.springframework.web.bind.annotation.*;


/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 09:40
 **/
@RestController
@RequestMapping("/api/cities")
public class CityController extends BaseController<City,CityService> {
    @GetMapping("/{id}/country")
    public City findByIdWithCity(@PathVariable("id") Short cityId){
        return service.findByIdWithCountry(cityId);
    }

    @Override
    public Class getEntityClass() {
        return City.class;
    }
}
