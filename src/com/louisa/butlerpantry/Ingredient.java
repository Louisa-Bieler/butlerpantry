package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingredient {
    private String name;
    private String unit;
    private BigDecimal amount;


//Constructor:
    public Ingredient(String name, String unit, BigDecimal amount) throws IllegalArgumentException {
        this.name = name;
        this.unit = unit;
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
        this.amount = amount;
    }

    public void addAmountFromShopping(BigDecimal amount) throws IllegalArgumentException {
        if (!(amount.compareTo(BigDecimal.valueOf(0)) <= 0)) {
            this.amount = this.amount.add(amount).setScale(2, RoundingMode.HALF_UP);
        } else {
            throw new IllegalArgumentException("Input amount cannot be a negative number");
        }
    }

    public void subtractAmountFromRecipe(BigDecimal amount) throws IllegalArgumentException {
        if (!(amount.compareTo(BigDecimal.valueOf(0)) <= 0)) {
            this.amount = this.amount.subtract(amount).setScale(2, RoundingMode.HALF_UP);
        } else {
            throw new IllegalArgumentException("Input amount cannot be a negative number");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(",").append(this.unit).append(",").append(this.amount.setScale(2, RoundingMode.HALF_UP).toString()).append("\n");
        return sb.toString();
    }
}