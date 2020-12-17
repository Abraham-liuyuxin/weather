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
import java.util.concurrent.Phaser;

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
        List<Map<String,Object>> list = weatherService.getbyn_y(js);
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
        List<Map<String,Object>> list = weatherService.getbyn_y_m(js);
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
        List<Map<String,Object>> list = weatherService.getbyn_y_m_d(js);
        return list;
    }




    /**
     * @return 返回数据库中的城市名列表--数据库city3(查看平均气温)
     */
    @RequestMapping("/getCityname3")
    public List<String> getCityname3(){
        List<Map<String,String>> list = weatherService.getCityname3();
        List<String> citylist = new ArrayList<>();
        for (Map<String,String> map : list){
            citylist.add(map.get("city"));
        }
        return citylist;
    }

    /**
     * @return 返回数据库中的城市名列表和id--数据库city3(查看平均气温)
     */
    @RequestMapping("/getCitynameAndid")
    public List<Map<String,String>> getCitynameAndid(){
        List<Map<String,String>> list = weatherService.getCitynameAndid();
        return list;
    }


    /**
     *
     * @param js for example:{"city_id":57687", "year":"2015"}
     * @return 返回该年平均气温 for example:{"tem_avg":"17.12"}
     */
    @RequestMapping("/getavgbyyear")
    public Map<String,String> getavgbyyear(@RequestBody(required = false) Map<String,String> js){
        String tem = weatherService.getavgbyyear(js);
        Map<String,String> result = new HashMap<>();
        result.put("tem_avg",tem);
        return result;
    }

    /**
     *
     * @param js for example:{"cityid":57687"}
     * @return 返回近五年平均气温 for example:{"tem_avg":"17.12"}
     */
    @RequestMapping("/getavgby5years")
    public Map<String,String> getavgby5years(@RequestBody(required = false) Map<String,String> js){
        String tem = weatherService.getavgby5years(js);
        Map<String,String> result = new HashMap<>();
        result.put("tem_avg",tem);
        return result;
    }

    /**
     *
     * @param js for example:{"cityid":57687"}
     * @return 返回近十年平均气温 for example:{"tem_avg":"17.12"}
     */
    @RequestMapping("/getavgby10years")
    public Map<String,String> getavgby10years(@RequestBody(required = false) Map<String,String> js){
        String tem = weatherService.getavgby10years(js);
        Map<String,String> result = new HashMap<>();
        result.put("tem_avg",tem);
        return result;
    }

    /**
     *
     * @param js for example:{"cityid":57687"}
     * @return 返回近15年平均气温 for example:{"tem_avg":"17.12"}
     */
    @RequestMapping("/getavgby15years")
    public Map<String,String> getavgby15years(@RequestBody(required = false) Map<String,String> js){
        String tem = weatherService.getavgby15years(js);
        Map<String,String> result = new HashMap<>();
        result.put("tem_avg",tem);
        return result;
    }


    /**
     *
     * @return 返回所有城市近5,10,15年的平均气温
     */
    @RequestMapping("/getAllavgtemps")
    public List<Map<String,String>> getAllavgtemps(){
        List<Map<String,String>> list;
        list = weatherService.getAllavgtemps();
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
