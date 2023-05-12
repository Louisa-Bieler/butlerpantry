package com.butlerpantry.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingredient {
    private String name;
    private String unit;
    private BigDecimal amount;


//Constructor:
    public Ingredient(String name, String unit, BigDecimal amount) throws IllegalArgumentException {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Ingredient name is blank. Check input!");
        } else {
            this.name = name;
        } if (unit.isEmpty()){
            throw new IllegalArgumentException("Ingredient unit is blank. Check input!");
        } else {
            this.unit = unit;
        }
        if (amount.compareTo(BigDecimal.valueOf(0))>=0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Input amount cannot be a negative number");
        }
    }
//Getters and Setters:
    public String getName() {
        return this.name;
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

    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setAmount(BigDecimal amount) {
        if (!(amount.compareTo(BigDecimal.valueOf(0)) <= 0)) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Input to setAmount() cannot be a negative number");
        }
    }

    public void addAmountFromShopping(BigDecimal amount) {
        this.amount = this.amount.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void subtractAmountFromRecipe(BigDecimal amount) {
        this.amount = this.amount.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(",").append(this.unit).append(",").append(this.amount.setScale(2, RoundingMode.HALF_UP).toString()).append("\n");
        return sb.toString();
    }
}