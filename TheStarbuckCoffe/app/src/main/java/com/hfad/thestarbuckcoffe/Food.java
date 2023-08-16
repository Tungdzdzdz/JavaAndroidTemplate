package com.hfad.thestarbuckcoffe;

public class Food extends FoodAndDrink {
    public static FoodAndDrink[] foods = {
            new Food("Pho", "Pho is a traditional dish of Vietnam and is considered one of the typical dishes for Vietnamese cuisine.", 35000, R.drawable.pho),
            new Food("Banh Mi", "Banh mi is a Vietnamese dish, with the outer layer being a loaf of toast with crispy skin, soft intestines, and a filling inside.", 15000, R.drawable.banh_mi),
            new Food("Hamburger", "Hamburger is a type of food consisting of a ground beef sandwich (usually beef) in the middle. Pieces of meat can be grilled, fried, smoked or grilled over an open fire.", 25000, R.drawable.hamburger)
    };

    public Food(String n, String description, int price, int idImage) {
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
