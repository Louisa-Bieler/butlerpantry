package com.louisa.outofhafermilk;

public class Ingredient {
    private String name;
    private String unit;
    private Double amount;

//Constructor:
    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }
//Getters and Setters:
    public String getName() {
        return this.name;
    }

    public void setName(String name) {

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getAmount() {
        return this.amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void addAmountFromShopping(Double amount) {
        this.amount += amount;
    }

    public void subtractAmountFromRecipe(Double amount) {
        this.amount -= amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "," + this.unit + "," + this.amount.toString() + "\n");
        return sb.toString();
    }
}