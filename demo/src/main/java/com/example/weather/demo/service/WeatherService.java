package com.example.weather.demo.service;

import com.example.weather.demo.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Resource
    private WeatherMapper weatherMapper;

    public List<Map<String,String>>getCityname(){
        List<Map<String,String>> list = null;
        try{
            list = weatherMapper.getCityname();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getbyname(Map<String,String> js){
        List<Map<String,Object>> list = null;
        try {
            list = weatherMapper.getWeatherbyname(js);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getbyn_y(Map<String,String> js){
        List<Map<String,Object>> list = null;
        try {
            list = weatherMapper.getbynameandyear(js);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getbyn_y_m(Map<String,String> js){
        List<Map<String,Object>> list = null;
        try {
            list = weatherMapper.getbyn_y_m(js);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getbyn_y_m_d(Map<String,String> js){
        List<Map<String,Object>> list = null;
        try {
            list = weatherMapper.getbyn_y_m_d(js);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
