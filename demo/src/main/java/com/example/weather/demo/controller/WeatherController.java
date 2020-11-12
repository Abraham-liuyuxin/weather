package com.example.weather.demo.controller;

import com.example.weather.demo.model.Test;
import com.example.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {
    @Resource
    private WeatherService weatherService;

    @RequestMapping("/getCityname")
    public List<String> getCityname(){
        List<Map<String,String>> list = weatherService.getCityname();
        List<String> citylist = new ArrayList<>();
            for (Map<String,String> map : list){
                citylist.add(map.get("cityname"));
            }
        return citylist;
    }

    @RequestMapping("/getbyname")
    public List<Map<String,Object>> getbyname(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    @RequestMapping("/getbyn_y")
    public List<Map<String,Object>> getbyn_y(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    @RequestMapping("/getbyn_y_m")
    public List<Map<String,Object>> getbyn_y_m(@RequestParam String js){
//        System.out.println(cityname);
//        System.out.println(year);
//        System.out.println(month);


        //Map<String,String> js = new HashMap<>();
//        js.put("cityname","北京");
//        js.put("year","2018");
//        js.put("month","02");

        //List<Map<String,Object>> list = weatherService.getbyname(js);
        System.out.println(js);
        List<Map<String,Object>> list = null;
        return list;
    }

    @RequestMapping("/getbyn_y_m_d")
    public List<Map<String,Object>> getbyn_y_m_d(@RequestParam Map<String,String> js){

        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    @RequestMapping("/test_conn")
    public String response(@RequestBody(required = false) Map<String,Object> test){
        int id = 11;
        String name = "行不通";
        try {
            name = test.get("name").toString();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(name);
        String str = "无了无了";
        return str;
    }


}
