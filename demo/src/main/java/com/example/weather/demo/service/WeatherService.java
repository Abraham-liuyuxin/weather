package com.example.weather.demo.service;

import com.example.weather.demo.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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

    public List<Map<String,String>>getCitynameAndid(){
        List<Map<String,String>> list = null;
        try{
            list = weatherMapper.getCitynameAndid();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,String>>getCityname3(){
        List<Map<String,String>> list = null;
        try{
            list = weatherMapper.getCityname3();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public String getavgbyyear(Map<String,String> js){
        Map<String, Double> avg = new HashMap<>();
        try{
            avg = weatherMapper.getAvgbyyear(js);
        } catch (Exception e){
            e.printStackTrace();
        }
        double t = avg.get("avg(T)");
        String result = String.format("%.2f",t);
        return result;
    }

    public String getavgby5years(Map<String,String> js){
        Map<String, Double> avg = new HashMap<>();
        try{
            avg = weatherMapper.getAvgby5years(js);
        } catch (Exception e){
            e.printStackTrace();
        }
        double t = avg.get("avg(T)");
        String result = String.format("%.2f",t);
        return result;
    }

    public String getavgby10years(Map<String,String> js){
        Map<String, Double> avg = new HashMap<>();
        try{
            avg = weatherMapper.getAvgby10years(js);
        } catch (Exception e){
            e.printStackTrace();
        }
        double t = avg.get("avg(T)");
        String result = String.format("%.2f",t);
        return result;
    }

    public String getavgby15years(Map<String,String> js){
        Map<String, Double> avg = new HashMap<>();
        try{
            avg = weatherMapper.getAvgby15years(js);
        } catch (Exception e){
            e.printStackTrace();
        }
        double t = avg.get("avg(T)");
        String result = String.format("%.2f",t);
        return result;
    }
}
