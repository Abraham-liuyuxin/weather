package com.example.weather.demo.controller;

import com.example.weather.demo.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherControllerTest {

    @Resource
    WeatherService weatherService;

    @Test
    void getCityname() {
        List<Map<String,String>> list = weatherService.getCityname();
        System.out.println(list);
        List<String> citylist = new ArrayList<>();
        for (Map<String,String> map : list){
            citylist.add(map.get("cityname"));
        }
        System.out.println(citylist);
    }

    @Test
    void getbyname() {
    }

    @Test
    void getbyn_y() {
    }

    @Test
    void getbyn_y_m() {
        Map<String,String> js = new HashMap<>();
        js.put("cityname","北京");
        js.put("year","2018");
        js.put("month","12");
        System.out.println(js);
        List<Map<String,Object>> list = weatherService.getbyn_y_m(js);
        System.out.println(list);
    }

    @Test
    void getbyn_y_m_d() {
        Map<String,String> js = new HashMap<>();
        js.put("cityname","北京");
        js.put("year","2018");
        js.put("month","12");
        js.put("day","03");
        System.out.println(js);
        List<Map<String,Object>> list = weatherService.getbyn_y_m_d(js);
        System.out.println(list);
    }
}