package com.example.myapplication.licenseplatesensor;

public class PlateNumberModel {

    private String color;
    private String make;
    private String model;
    private String plate;
    private String URL;

    public PlateNumberModel() {
    }

    public PlateNumberModel(String color, String make, String model, String plate, String URL) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.URL = URL;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getURL() {
        return URL;
    }
}
