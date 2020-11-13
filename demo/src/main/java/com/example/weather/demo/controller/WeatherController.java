package com.example.weather.demo.controller;

import com.example.weather.demo.model.Test;
import com.example.weather.demo.service.WeatherService;
import org.apache.ibatis.annotations.Param;
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

    /**
     * @return 返回数据库中的城市名列表
     */
    @RequestMapping("/getCityname")
    public List<String> getCityname(){
        List<Map<String,String>> list = weatherService.getCityname();
        List<String> citylist = new ArrayList<>();
            for (Map<String,String> map : list){
                citylist.add(map.get("cityname"));
            }
        return citylist;
    }

    /**
     * @param js for example:{"cityname":"北京"}
     */
    @RequestMapping("/getbyname")
    public List<Map<String,Object>> getbyname(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    /**
     * @param js for example:{"cityname":"北京", "year":"2018"}
     */
    @RequestMapping("/getbyn_y")
    public List<Map<String,Object>> getbyn_y(@RequestParam Map<String,String> js){
        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    /**
     * @param js for example:{"cityname":"北京", "year":"2018", "month":"08"}
     */
    @RequestMapping("/getbyn_y_m")
    public List<Map<String,Object>> getbyn_y_m(@RequestParam Map<String,String> js){
//        System.out.println(cityname);
//        System.out.println(year);
//        System.out.println(month);
//        Map<String,String> js = new HashMap<>();
//        js.put("cityname","北京");
//        js.put("year","2018");
//        js.put("month","02");
        List<Map<String,Object>> list = weatherService.getbyname(js);
        System.out.println(js);
        return list;
    }

    /**
     * 若用axios库的post传递参数，请用Qs库的stringify()将对象化序列的参数转化为url形式
     * @param js for example:{"cityname":"北京", "year":"2018", "month":"08", "day":"08"}
     * @return 返回一个列表，该列表里只有该天的天气数据
     */
    @RequestMapping("/getbyn_y_m_d")
    public List<Map<String,Object>> getbyn_y_m_d(@RequestParam Map<String,String> js){

        List<Map<String,Object>> list = weatherService.getbyname(js);
        return list;
    }

    @RequestMapping("/test_conn2")
    public Map<String,String> response2(@RequestParam(required = false) Map<String,String> test){
        String id = "error2";
        String name = "行不通2";
        try {
            id = test.get("id");
            name = test.get("name");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(name);
        Map<String,String> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        return result;
    }

    @RequestMapping("/test_conn")
    public Map<String,String> response(@RequestBody(required = false) Map<String,Object> test){
        String id = "";
        String name = "行不通";
        try {
            id = test.get("id").toString();
            name = test.get("name").toString();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(name);
        Map<String,String> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        return result;
    }


}
