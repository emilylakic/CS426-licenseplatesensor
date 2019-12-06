package com.example.myapplication.licenseplatesensor;

//This class receives data from the Android device to display on the database
public class Member {

    //Sets objects for the name, plate number, model, and color of the vehicle inputted by the user
    private String Name;
    private String Plate;
    private String Model;
    private String Color;

    //Constructor
    public Member() {

    }

    //Getter method for name
    public String getName() {
        return Name;
    }

    //Setter method for name
    public void setName(String name) {
        Name = name;
    }

    //Getter method for vehicle model
    public String getModel() {
        return Model;
    }

    //Setter method for vehicle model
    public void setModel(String model) {
        Model = model;
    }

    //Getter method for vehicle color
    public String getColor() {
        return Color;
    }

    //Setter method for vehicle color
    public void setColor(String color) {
        Color = color;
    }

    //Getter method for plate number
    public String getPlate() {
        return Plate;
    }

    //Setter method for plate number
    public void setPlate(String plate) {
        Plate = plate;
    }
}
