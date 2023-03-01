package com.louisa.butlerspantry;


import java.util.*;
import java.lang.Double;
import java.lang.String;


public class Pantry {

    private int pantryId;
    private static int pantryIdGenerator = 0;
    private HashMap<String, HashMap<String, Double>> inventory;

    public Pantry() {
        pantryId = ++pantryIdGenerator;
    }

    public HashMap<String, HashMap<String, Double>> getInventory(){
        return this.inventory;
    }

    public void setInventory(HashMap<String, HashMap<String, Double>> newInventory){
        this.inventory = newInventory;
    }

    public Set<String> getIngredientNames(){
        return this.inventory.keySet();
    }



    public void setIngredient(String ingredientName, String unitName, Double amount){
        if (this.inventory != null){
            if(this.inventory.containsKey(ingredientName)){
                updateIngredient(ingredientName, unitName, amount);
            }
        } else {
            this.inventory = new HashMap<>();
        }
        HashMap<String, Double> innerHashMap = new HashMap<>();
        innerHashMap.put(unitName, amount);
        this.inventory.put(ingredientName, innerHashMap);
    }

    public void updateIngredient(String ingredientName, String unitName, Double newAmount){
        Double previousAmount = this.inventory.get(ingredientName).putIfAbsent(unitName, newAmount);
        if (previousAmount != null){
            this.inventory.get(ingredientName).replace(unitName, previousAmount + newAmount);
        }
    }

    public void removeIngredient(String ingredientName, String unitName){
        this.inventory.get(ingredientName).remove(unitName);
        if (this.inventory.get(ingredientName).keySet().isEmpty()) {
            this.inventory.remove(ingredientName);
        }
    }
    @Override
    public String toString() {
        Iterator<Map.Entry<String, HashMap<String, Double>>> ingredientIterator = this.inventory.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (ingredientIterator.hasNext()) {
            String iterationKey = ingredientIterator.next().getKey();

            sb.append(iterationKey + "," + this.inventory.get(iterationKey).toString().replace("{","").replace("}", "").replace("=", ",") + "\n");
        }
        return "Pantry ID: " + this.pantryId + "\n" + sb;
    }
    /*
    public Ingredient getIngredient(String name) {
        return this.inventory.get(name);
    }

    public void addShopping(Pantry entries) {
        entries.getInventory().forEach(
                (key, value) ->
                        this.inventory.merge(
                                key, value, (value1, value2) ->
                                {
                                    value1.addAmountFromShopping(value2.getUnitAmount());
                                    return value1;
                                }
                        )
        );
    }

    public Pantry updatePantryWithRecipe(Pantry recipe) {
        Pantry shoppingList = new Pantry();
        recipe.getInventory().forEach(
                (recipeIngredientName, recipeIngredient) ->
                {
                    if (this.getInventory().keySet().contains(recipeIngredientName)) {
                        shoppingList.setIngredientFromIngredient(this.getIngredient(recipeIngredientName));
                        this.getIngredient(recipeIngredientName).setAmountFromRecipe(recipeIngredient);
                        shoppingList.replaceIngredient(shoppingList.getIngredient(recipeIngredientName).createShoppingListIngredient(recipeIngredient));
                    } else {
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    }
                }
        );
        return shoppingList;
    }
    */


}





