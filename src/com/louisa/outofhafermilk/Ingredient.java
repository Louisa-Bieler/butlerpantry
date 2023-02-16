package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

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

    public Ingredient(String message) {
        String line = message;
        String[] lineParts = line.split(",");
        String name = lineParts[0];
        String unit = lineParts[1];
        Double amount = Double.parseDouble(lineParts[2]);
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

    public void removeUnit(String unit) { this.units.remove(unit); this.unitAmount.remove(unit, 0); }

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
        String noMore = null;
        for (int i = 0; i < numberOfUnitsToUpdate; i++) {
            String iterationUnitName = unitNames.get(i);
            if (this.getUnitAmount().containsKey(iterationUnitName)) {
                Double newValue = this.getAmount(iterationUnitName) - recipeIngredientUnitAmount.get(iterationUnitName);
                if (newValue > 0) {
                    this.getUnitAmount().replace(iterationUnitName, newValue);
                    String success = "Success!";
                    Logger.logNow(success);
                } else if (newValue == 0) {
                    this.unitAmount.remove(iterationUnitName);
                    noMore = iterationUnitName;
                } else if (newValue < 0){
                    Double toBuy = newValue * -1;
                    goShopping = this.name + "," + iterationUnitName + "," + toBuy;
                }
            } else {
                dontHave = this.name + "," + iterationUnitName + "," + recipeIngredientUnitAmount.get(iterationUnitName);
            }
        }
            if (goShopping != null) {
                return goShopping;
            } else if (noMore != null) {
                return noMore;
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

