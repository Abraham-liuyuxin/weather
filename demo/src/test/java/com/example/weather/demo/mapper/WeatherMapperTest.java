package com.example.weather.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherMapperTest {

    @Resource
    private WeatherMapper weatherMapper;

    @Test
    void getAvgbyyear() {
        Map<String, Double> avg = new HashMap<>();
        Map<String, String> js = new HashMap<>();
        js.put("cityid", "57687");
        js.put("year", "2015");
        avg = weatherMapper.getAvgbyyear(js);
        System.out.println(avg);
        System.out.println(avg.values());
        String t = avg.get("avg(T)").toString();
        double tt = avg.get("avg(T)");
        String ttt = String.format("%.2f", tt);
        System.out.println(ttt);
        System.out.println(t);
//        List<String> valuesList = new ArrayList<String>();
//        System.out.println(valuesList.get(0));

    }

    @Test
    void getWeatherbyname() {
        List<Map<String,String>> list = null;
        try{
            list = weatherMapper.getCityname();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list);
    }


    @Test
    void getAvgby5years() {
        Map<String, Double> avg;
        Map<String, String> js = new HashMap<>();
        js.put("cityid", "57687");
        avg = weatherMapper.getAvgby5years(js);
        System.out.println(avg);
    }

    @Test
    void getAvgby10years() {
        Map<String, Double> avg;
        Map<String, String> js = new HashMap<>();
        js.put("cityid", "57687");
        avg = weatherMapper.getAvgby10years(js);
        System.out.println(avg);
    }

    @Test
    void getAvgby15years() {
        Map<String, Double> avg;
        Map<String, String> js = new HashMap<>();
        js.put("cityid", "57687");
        avg = weatherMapper.getAvgby15years(js);
        System.out.println(avg);
    }

    @Test
    void getCitynameAndid() {
        List<Map<String,String>> list;
        list = weatherMapper.getCitynameAndid();
        for (Map<String,String> map:list){
            System.out.println(map);
        }
    }

    @Test
    void getCityname3() {
        List<Map<String,String>> list;
        list = weatherMapper.getCityname3();
        for (Map<String,String> map:list){
            System.out.println(map);
        }
    }

}



















