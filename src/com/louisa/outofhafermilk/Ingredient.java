package com.louisa.outofhafermilk;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ingredient {
    private String name;
    private ArrayList<String> unit;

    private HashMap<String, Double> type;


    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.unit.add(unit);
        this.type.put(unit, amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Double> getAmount() {
        return type;
    }

    public void setAmount(String unit, Double amount) {
        if (this.unit.contains(unit)) {
            Double newValue = this.type.get(unit) + amount;
            type.replace(unit, newValue);
        } else {
            this.type.put(unit, amount);
        }

    }

        public HashMap<String, Double> getType() {
            return type;
    }

    @Override
    public String toString() {
        List<String> stringyIngredient = new ArrayList<>();
        for (int i = 0; i < this.unit.size(); i++) {
            stringyIngredient.add(this.name + ", " + this.unit.get(i) + ", " + this.type.get(this.unit.get(i)));
        }
        return stringyIngredient.toString();
    }}

