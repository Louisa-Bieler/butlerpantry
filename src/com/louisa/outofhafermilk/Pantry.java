package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.*;
import java.lang.Double;
import java.lang.String;
import java.util.stream.Collectors;

import static com.louisa.outofhafermilk.ReadFile.readFile;



public class Pantry {
    private HashMap<String, Ingredient> inventory;


    public Pantry(String defaultPantryFilePath) {
        File testFile  = readFile(defaultPantryFilePath);
        this.inventory = ProduceIngredientHashMapFromFile.produceIngredients(testFile);
    }

    public Pantry(HashMap<String, Ingredient> inventory){
        this.inventory = inventory;
    }

    public HashMap<String, Ingredient> getInventory() {
        return inventory;
    }


    public void setInventory(HashMap<String, Ingredient> inventory) {
        this.inventory = inventory;
    }

    public void setIngredient(String name, String unit, Double amount){
        if (this.inventory.keySet().contains(name)){
            if (this.inventory.get(name).getUnits().contains(unit)){
                Double newValue = this.inventory.get(name).getUnitAmount().get(unit) + amount;
                Ingredient updatedIngredientUnitAmount = new Ingredient(name, unit, newValue);
                this.inventory.replace(name, updatedIngredientUnitAmount);
            } else {
                Ingredient temp = this.inventory.get(name);
                temp.addUnits(unit);
                temp.setAmountFromScratch(unit, amount);
                this.inventory.replace(name, temp);
            }
        } else {
            Ingredient newIngredient = new Ingredient(name, unit, amount);
            this.inventory.put(name, newIngredient);
        }
    }

    public void removeEntireIngredient(String name){
        this.inventory.remove(name);
    }



    @Override
    public String toString() {
        Iterator<String> stringIterator =  this.inventory.keySet().iterator();
        ArrayList<String> stringyPantry = new ArrayList<>();
        while (stringIterator.hasNext()){
            String iterationName = stringIterator.next();
            Iterator<String> iterationUnits = this.inventory.get(iterationName).getUnits().iterator();
            while (iterationUnits.hasNext()){
                String iterationUnit = iterationUnits.next();
                String iterationAmount = String.valueOf(this.inventory.get(iterationName).getUnitAmount().get(iterationUnit));
                stringyPantry.add(iterationName + "," + iterationUnit + "," + iterationAmount);
            }
        }
        return stringyPantry.toString().replaceAll("\\[","").replaceAll("\\]","");
    }
 
    public Ingredient getIngredient(String name) {
        return this.inventory.get(name);
    }

    public void updatePantry(HashMap<String, Ingredient> entries) {
        HashMap<String, Ingredient> currentPantry = this.getInventory();
        List<String> ingredientsToUpdate = entries.keySet().stream().collect(Collectors.toList());
        int numberOfIngredientsToUpdate = entries.size();
        for (int i = 0; i < numberOfIngredientsToUpdate; i ++){
            String iterationIngredientName = ingredientsToUpdate.get(i);
            if (currentPantry.containsKey(iterationIngredientName)) {
                Ingredient temp = this.inventory.get(iterationIngredientName);
                temp.setAmountFromExistingIngredients(entries.get(iterationIngredientName).getUnitAmount());
                this.inventory.replace(temp.getName(), temp);
            }else {
                this.inventory.put(iterationIngredientName, entries.get(iterationIngredientName));
            }
        }
         
    }

    public Pantry updatePantryWithRecipe(HashMap<String, Ingredient> recipe) {
        HashMap<String, Ingredient> currentPantry = this.getInventory();
        List<String> ingredientsToUpdate = recipe.keySet().stream().collect(Collectors.toList());
        Pantry shoppingList = new Pantry(recipe);
        int numberOfIngredientsToUpdate = recipe.size();
        ArrayList<String> messages = new ArrayList<>();
        for (int i = 0; i < numberOfIngredientsToUpdate; i ++){
            String iterationIngredientName = ingredientsToUpdate.get(i);
            if (currentPantry.containsKey(iterationIngredientName)) {
                Ingredient temp = currentPantry.get(iterationIngredientName);
                String message = temp.setAmountFromRecipe(recipe.get(iterationIngredientName).getUnitAmount());
                messages.add(message);
                if (message.contains("Success")) {
                    this.inventory.replace(temp.getName(), temp);
                    shoppingList.removeEntireIngredient(iterationIngredientName);
                }
                else {
                    continue;
                }
            }else {
                //this.inventory.put(iterationIngredientName, entries.get(iterationIngredientName));
            }
        }

    }
}



