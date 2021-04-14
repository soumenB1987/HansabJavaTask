package com.hasab.hansabtask.Data.Schemas;

public class Car {

    private Integer id;
    private String make;
    private String model;
    private String numberplate;

    public Car(Integer id, String make, String model, String numberplate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.numberplate = numberplate;
    }

    public Car() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }
}
