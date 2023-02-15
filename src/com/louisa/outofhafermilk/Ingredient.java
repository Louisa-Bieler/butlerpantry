package com.louisa.outofhafermilk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Ingredient {
    private String name;
    private ArrayList<String> units = new ArrayList<>();

    private HashMap<String, Double> unitAmount = new HashMap<>();


    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.units.add(unit);
        this.unitAmount.put(unit, amount);
    }

    public String getName() {
        return name;
    }

    public void addUnits(String newUnit) {
        this.units.add(newUnit);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount(String unit) {
        return unitAmount.get(unit);
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    public void setAmountFromScratch(String unit, Double amount) {
        if (this.units.contains(unit)) {
            Double newValue = this.unitAmount.get(unit) + amount;
            this.unitAmount.replace(unit, newValue);
        } else {
            this.addUnits(unit);
            this.unitAmount.put(unit, amount);
        }

    }
    public void setAmountFromExistingIngredients(HashMap<String, Double> updatingIngredientType){
        List<String> unitNames = updatingIngredientType.keySet().stream().collect(Collectors.toList());
        int numberOfUnitsToUpdate = updatingIngredientType.size();
        for (int i = 0; i < numberOfUnitsToUpdate; i++){
            String iterationUnitName = unitNames.get(i);
            if (this.getUnitAmount().containsKey(iterationUnitName)){
                Double newValue = this.getAmount(iterationUnitName) + updatingIngredientType.get(iterationUnitName);
                this.getUnitAmount().replace(iterationUnitName, newValue);
            } else {
                this.setAmountFromScratch(iterationUnitName, updatingIngredientType.get(iterationUnitName));
            }
            }}
    public HashMap<String, Double> getUnitAmount() {
        return unitAmount;
    }
    public String setAmountFromRecipe(HashMap<String, Double> recipeIngredientUnitAmount){
        List<String> unitNames = recipeIngredientUnitAmount.keySet().stream().collect(Collectors.toList());
        int numberOfUnitsToUpdate = recipeIngredientUnitAmount.size();
        String goShopping = null;
        String dontHave = null;
        for (int i = 0; i < numberOfUnitsToUpdate; i++) {
            String iterationUnitName = unitNames.get(i);
            if (this.getUnitAmount().containsKey(iterationUnitName)) {
                Double newValue = this.getAmount(iterationUnitName) - recipeIngredientUnitAmount.get(iterationUnitName);
                if (newValue >= 0) {
                    this.getUnitAmount().replace(iterationUnitName, newValue);
                    String message = "Success!";
                    return message;
                } else {
                    Double toBuy = newValue * -1;
                    goShopping = this.name + "," + iterationUnitName + "," + toBuy;
                    continue;
                }
            } else {
                dontHave = this.name + "," + iterationUnitName + "," + recipeIngredientUnitAmount.get(iterationUnitName);
                continue;
            }}
            if (goShopping != null) {
                return goShopping;
            } else {
                return dontHave;
            }
    }
    @Override
    public String toString() {
        List<String> stringyIngredient = new ArrayList<>();
        for (int i = 0; i < this.units.size(); i++) {
            stringyIngredient.add(this.name + ", " + this.units.get(i) + ", " + this.unitAmount.get(this.units.get(i)));
        }
        return stringyIngredient.toString();
    }}

