package com.hfad.thestarbuckcoffe;

public class Drink extends FoodAndDrink {
    public static FoodAndDrink[] drinks = {
            new Drink("Lemon Tea", "Lemon tea is a favorite drink of many people thanks to its sweet and sour taste, refreshing and satisfying the need for cooling and refreshment on hot days. Not only that, the way to make lemon tea at home is also extremely simple and does not take too much time.", 15000, R.drawable.tra_chanh),
            new Drink("Latte", "Coffee latte, referred to as latte for short, is a drink originating from Italy. In Scandinavia and Northern Europe, the name latte refers to a drink that combines espresso and milk, while the French latte is a combination of espresso and whipped (stirred) milk.", 30000, R.drawable.latte),
            new Drink("Cappuccino", "Cappuccino is a drink originating from Italy consisting of coffee and whipped milk", 35000, R.drawable.cappuccino)
    };

    public Drink(String n, String description, int price, int idImage) {
        super(n, description, price, idImage);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getIdImage() {
        return super.getIdImage();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
