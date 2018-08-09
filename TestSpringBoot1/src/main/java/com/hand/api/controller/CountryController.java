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
public class CountryController {
    private static final Logger logger = Logger.getLogger(CountryController.class);
    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country save(@RequestBody Country country) {
        country.setLastUpdate(new Date());
        countryService.save(country);
        logger.info("save country:" + country);
        return country;
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable("id") Short countryId, @RequestBody Country country) {
        Country oldCountry = countryService.getById(countryId);
        country.setLastUpdate(new Date());
        country.setCountryId(oldCountry.getCountryId());
        countryService.update(country);
        logger.info("update oldCountry:" + oldCountry + " to " + country);
        return country;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short countryId) {
        countryService.deleteById(countryId);
        logger.info("delete country:" + countryId);
    }

    @GetMapping("/{id}")
    public Country get(@PathVariable("id") Short countryId) {
        logger.info("get city:" + countryId);
        return countryService.getById(countryId);
    }

    @GetMapping
    public List<Country> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "1") Short pageSize
            , @RequestParam(value = "pageNum", required = false, defaultValue = "10") Short pageNum
            , @RequestParam(value = "country", required = false, defaultValue = "") Short country) {
        logger.info("getAll country pageSize:" + pageSize + ",pageNum:" + pageNum);
        return countryService.getAll("", pageSize, pageNum);
    }

    @GetMapping("/{id}/cities")
    public Country findByIdWithCity(@PathVariable("id") Short countryId){
        return countryService.findByIdWithCity(countryId);
    }
}
