package com.hand.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 22:00
 **/
@RestController
@RequestMapping("/api")
public class ApiController {
    @Value("${base.url}")
    //private static String BASE_URL;不能成功注入值
    private String BASE_URL;
    @GetMapping
    public Map<String,String> api(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("film_url", BASE_URL+"films");
        map.put("actor_url", BASE_URL+"actors");
        map.put("city_url", BASE_URL+"cities");
        map.put("country_url", BASE_URL+"countrys");
        return map;
    }
}
