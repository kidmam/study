package com.power.study;

public class NutritionFacts {

    private int sodium;
    private int carbohydrate;
    private int servings;

    public NutritionFacts() {
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setCarbohydrate(1);
    }
}
