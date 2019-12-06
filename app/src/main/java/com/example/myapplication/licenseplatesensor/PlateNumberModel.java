package com.example.myapplication.licenseplatesensor;

//This class receives data from the database to display on the Android device
public class PlateNumberModel {

    //Sets objects for the color, make, model, plate, and URL of the vehicle recognized by the picamera
    private String color;
    private String make;
    private String model;
    private String plate;
    private String URL;

    //Constructor
    public PlateNumberModel() {
    }

    //To be able to use color, make, model, plate, and URL
    public PlateNumberModel(String color, String make, String model, String plate, String URL) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.URL = URL;
    }

    //Getters for color, make, model, and plate
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

    //Setters for color, make, model, and plate
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

    //Get URL for each image snapped by picamera
    public String getURL() {
        return URL;
    }
}
