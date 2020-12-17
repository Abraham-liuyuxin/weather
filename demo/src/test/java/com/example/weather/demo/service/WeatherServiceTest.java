package com.example.weather.demo.service;

import com.example.weather.demo.mapper.WeatherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherServiceTest {
    @Resource
    WeatherService weatherService;

    @Test
    void getAllavgtemps() {
        List<Map<String,String>> list = weatherService.getAllavgtemps();
        for (Map<String,String> map:list){
            System.out.println(map);
        }
    }
}