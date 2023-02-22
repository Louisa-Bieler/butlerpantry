package com.louisa.outofhafermilk;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Ingredient {
    private String name;
    private HashMap<String, Double> unitAmount = new HashMap<>();




    public Ingredient(String name, String unit, Double amount){
        this.name = name;
        this.unitAmount.put(unit, amount);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount(String unit) {
        return unitAmount.get(unit);
    }

    public void removeUnit(String unit) { this.unitAmount.remove(unit); }

    public String getFirstUnit() {
        return this.unitAmount.keySet().stream().collect(Collectors.toList()).get(0); }

    public void setAmountFromScratch(String unit, Double amount) {
        if (this.unitAmount.containsKey(unit)) {
            Double newValue = this.unitAmount.get(unit) + amount;
            this.unitAmount.replace(unit, newValue);
        } else {
            this.unitAmount.put(unit, amount);
        }
    }


    public void addAmountFromShopping(HashMap<String, Double> updatingUnitAmount) {
        updatingUnitAmount.forEach(
                (key, value)
                        -> this.unitAmount.merge(
                        key, value, (v1, v2) -> v1 + v2));
    }

    public HashMap<String, Double> getUnitAmount() {
        return unitAmount;
    }
    public HashMap<String, Double> setAmountFromRecipe(Ingredient recipeIngredient){
        HashMap<String, Double> tempUnitAmounts = recipeIngredient.getUnitAmount();
        this.unitAmount.forEach(
                (unitKey, unitValue) ->
                    tempUnitAmounts.merge(
                            unitKey, unitValue, (value1, value2)
                                    -> value1 - value2));
        tempUnitAmounts.forEach(
                (updatedKey, updatedValue) ->
                { if (updatedValue > 0){
                    this.setAmountFromScratch(updatedKey, updatedValue);
                    tempUnitAmounts.remove(updatedKey);
                } else if (updatedValue < 0) {
                    tempUnitAmounts.replace(updatedKey, updatedValue *-1);
                } else {
                    this.removeUnit(updatedKey);
                }});
        return tempUnitAmounts;
    }

    @Override
    public String toString() {
        Iterator<String> stringIterator = this.getUnitAmount().keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (stringIterator.hasNext()) {
            String iterationUnit = stringIterator.next();
            String iterationAmount = String.valueOf(this.getUnitAmount().get(iterationUnit));
            sb.append(this.name + "," + iterationUnit + "," + iterationAmount + "\n");
        }
        return sb.toString();
    }

    public static class IngredientFactory {
    //Figure out how to do a hash map with the key as the combo of name and unit

    //(Nested class)
        public static Ingredient returnIngredient(String g) {

            String line = g;
            String[] lineParts = line.split(",");
            String name = lineParts[0];
            String unit = lineParts[1];
            Double amount = Double.parseDouble(lineParts[2]);
            Ingredient newIngredient  = new Ingredient(name, unit, amount);
            //if the unit is not in this list, then just go put it in
            //unless it has an empty character, or unacceptable type of string like lots of punctuation or digits or such
            //if it is in this list(maintained forced lower case list of possible iterations of weight or volume)
            //if a decaliter comes in we want to multply by the factor instead of dividing hence the factor should be a Double
            return newIngredient;

        }

    }
}