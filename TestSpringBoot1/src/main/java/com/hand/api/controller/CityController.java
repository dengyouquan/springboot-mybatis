package com.hand.api.controller;

import com.hand.api.service.CityService;
import com.hand.domain.entity.City;
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
@RequestMapping("/api/cities")
public class CityController {
    private static final Logger logger = Logger.getLogger(CityController.class);
    @Autowired
    private CityService cityService;

    @PostMapping
    public City save(@RequestBody City city) {
        city.setLastUpdate(new Date());
        cityService.save(city);
        logger.info("save city:" + city);
        return city;
    }

    @PutMapping("/{id}")
    public City update(@PathVariable("id") Short cityId, @RequestBody City city) {
        City oldCity = cityService.getById(cityId);
        city.setLastUpdate(new Date());
        city.setCityId(oldCity.getCityId());
        cityService.update(city);
        logger.info("update oldCity:" + oldCity + " to " + city);
        return city;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short cityId) {
        cityService.deleteById(cityId);
        logger.info("delete city:" + cityId);
    }

    @GetMapping("/{id}")
    public City get(@PathVariable("id") Short cityId) {
        logger.info("get city:" + cityId);
        return cityService.getById(cityId);
    }

    @GetMapping
    public List<City> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "1") Short pageSize
            , @RequestParam(value = "pageNum", required = false, defaultValue = "10") Short pageNum) {
        logger.info("getAll city pageSize:" + pageSize + ",pageNum:" + pageNum);
        return cityService.getAll(pageSize, pageNum);
    }

    @GetMapping("/{id}/country")
    public City findByIdWithCity(@PathVariable("id") Short cityId){
        return cityService.findByIdWithCountry(cityId);
    }
}
