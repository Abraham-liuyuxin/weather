package com.example.weather.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface WeatherMapper {

    @Select("select * " +
            "from city a inner join wea_info1 b " +
            "on a.city_id = b.city_id " +
            "where a.cityname = (#{js.cityname})")
    public List<Map<String,Object>>getWeatherbyname(@Param("js") Map<String,String> map);

    @Select("select * " +
            "from city a inner join wea_info1 b " +
            "on a.city_id = b.city_id " +
            "where a.cityname = (#{js.cityname}) " +
            "and b.year = (#{js.year})")
    public List<Map<String,Object>>getbynameandyear(@Param("js") Map<String,String> map);

    @Select("select * " +
            "from city a inner join wea_info1 b " +
            "on a.city_id = b.city_id " +
            "where a.cityname = (#{js.cityname}) " +
            "and b.year = (#{js.year}) " +
            "and b.month = (#{js.month})")
    public List<Map<String,Object>>getbyn_y_m(@Param("js") Map<String,String> map);

    @Select("select * " +
            "from city a inner join wea_info1 b " +
            "on a.city_id = b.city_id " +
            "where a.cityname = (#{js.cityname}) " +
            "and b.year = (#{js.year}) " +
            "and b.month = (#{js.month}) " +
            "and b.day = (#{js.day})")
    public List<Map<String,Object>>getbyn_y_m_d(@Param("js") Map<String,String> map);

    @Select("select ")
    public double getAvg(@Param("js") Map<String,String> map);
}
