package com.hfad.thestarbuckcoffe;

public class FoodAndDrink {
    private String name, description;
    private int price, idImage;

    public FoodAndDrink(String n, String description, int price, int idImage) {
        this.name = n;
        this.description = description;
        this.price = price;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getIdImage() {
        return idImage;
    }

    @Override
    public String toString() {
        return getName();
    }
}
