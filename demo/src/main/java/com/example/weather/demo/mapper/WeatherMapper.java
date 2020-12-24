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

    @Select("select cityname from city")
    public List<Map<String,String>>getCityname();

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

    @Select("select * from city3")
    public List<Map<String,String>>getCitynameAndid();

    @Select("select city from city3")
    public List<Map<String,String>>getCityname3();

    @Select("select avg(T) from wea_info3_1 " +
            "where city_id = (#{js.cityid}) " +
            "and date like CONCAT('%',#{js.year})")
    public Map<String,Double> getAvgbyyear(@Param("js") Map<String,String> map);

    @Select("select avg(T) from wea_info3_1 " +
            "where city_id = (#{js.cityid}) " +
            "and ( date like '%2015' or date like '%2016' or date like '%2017' or date like '%2018' or date like '%2019' or date like '%2020' )")
    public Map<String,Double> getAvgby5years(@Param("js") Map<String,String> map);

    @Select("select avg(T) from wea_info3_1 " +
            "where city_id = (#{js.cityid}) " +
            "and ( date like '%2015' or date like '%2016' or date like '%2017' or date like '%2018' or date like '%2019' or date like '%2020' " +
            "or date like '%2010' or date like '%2011' or date like '%2012' or date like '%2013' or date like '%2014' )")
    public Map<String,Double> getAvgby10years(@Param("js") Map<String,String> map);

    @Select("select avg(T) from wea_info3_1 " +
            "where city_id = (#{js.cityid}) ")
    public Map<String,Double> getAvgby15years(@Param("js") Map<String,String> map);

    @Select("select * from temp_avg")
    public List<Map<String,String>> getAllavgtemps();

    @Select("select avg(T) from wea_info3_1 " +
            "where date like CONCAT('%',#{js.my})" +
            "and city_id = (#{js.cityid})")
    public Map<String,Double> getavgbymonth(@Param("js") Map<String,String> map);
}
