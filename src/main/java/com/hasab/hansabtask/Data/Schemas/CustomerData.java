package com.hasab.hansabtask.Data.Schemas;

import java.util.List;

public class CustomerData {

    private String name;
    private Integer id;
    private List<Car> cars;

    public CustomerData(Integer id, String name, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
