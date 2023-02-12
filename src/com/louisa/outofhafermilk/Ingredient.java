package com.louisa.outofhafermilk;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ingredient {
    private String name;
    private ArrayList<String> units = new ArrayList<>();

    private HashMap<String, Double> type = new HashMap<>();


    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.units.add(unit);
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

    public ArrayList<String> getUnits() {
        return units;
    }

    public void setAmountFromScratch(String unit, Double amount) {
        if (this.units.contains(unit)) {
            Double newValue = this.type.get(unit) + amount;
            this.type.replace(unit, newValue);
        } else {
            this.type.put(unit, amount);
        }

    }
    public void setAmountFromExistingIngredients(HashMap<String, Double> updatingIngredientType){
        List<String> unitNames = updatingIngredientType.keySet().stream().toList();
        int numberOfUnitsToUpdate = updatingIngredientType.size();
        for (int i = 0; i < numberOfUnitsToUpdate; i++){
            String iterationUnitName = unitNames.get(i);
            if (this.type.containsKey(iterationUnitName)){
                Double newValue = this.type.get(iterationUnitName) + updatingIngredientType.get(iterationUnitName);
                this.type.replace(iterationUnitName, newValue);
            } else {
                this.type.put(iterationUnitName, updatingIngredientType.get(iterationUnitName));
            }
            }}
        public HashMap<String, Double> getType() {
            return type;
    }

    @Override
    public String toString() {
        List<String> stringyIngredient = new ArrayList<>();
        for (int i = 0; i < this.units.size(); i++) {
            stringyIngredient.add(this.name + ", " + this.units.get(i) + ", " + this.type.get(this.units.get(i)));
        }
        return stringyIngredient.toString();
    }}

