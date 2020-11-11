package com.example.weather.demo.controller;

import com.example.weather.demo.service.WeatherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {
    @Resource
    private WeatherService weatherService;

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
    public List<Map<String,Object>> getbyn_y_m(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    @RequestMapping("/getbyn_y_m_d")
    public List<Map<String,Object>> getbyn_y_m_d(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }


}
