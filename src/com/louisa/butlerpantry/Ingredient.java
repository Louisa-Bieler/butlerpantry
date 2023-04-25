package com.louisa.butlerpantry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingredient {
    private String name;
    private String unit;
    private BigDecimal amount;


//Constructor:
    public Ingredient(String name, String unit, BigDecimal amount){
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

    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void addAmountFromShopping(BigDecimal amount) {
        this.amount.add(amount);
    }

    public void subtractAmountFromRecipe(BigDecimal amount) {
        this.amount.subtract(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "," + this.unit + "," + this.amount.setScale(2, RoundingMode.HALF_UP).toString() + "\n");
        return sb.toString();
    }
}