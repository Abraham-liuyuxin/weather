package com.example.weather.demo.model;

public class Test {

    private String name;
    private Integer id;

    public Test(String name, Integer id){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
