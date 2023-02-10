package com.louisa.outofhafermilk;


public class Ingredient {
    private String name;
    private String unit;
    private double amount;


    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        String thisName = this.name.format("%s, ", this.name);
        String thisUnit = this.unit.format("%s, ", this.unit);
        String thisAmount = String.valueOf(this.amount).format("%s", String.valueOf(this.amount));
        String thisIngredient = thisName + thisUnit + thisAmount;
       return thisIngredient;
    }
}
