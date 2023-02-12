package com.louisa.outofhafermilk;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.Double;
import java.lang.String;

import static com.louisa.outofhafermilk.ReadFile.readFile;



public class Pantry {
    public String defaultPantryFilePath;
    private File testFile;
    private HashMap<String, Ingredient> inventory;


    public Pantry(String defaultPantryFilePath) {
        this.defaultPantryFilePath = defaultPantryFilePath;
        this.testFile  = readFile(defaultPantryFilePath);
        this.inventory = ProduceIngredientHashMapFromFile.produceIngredients(testFile);
    }

    public HashMap<String, Ingredient> getInventory() {
        return inventory;
    }


    public void setInventory(HashMap<String, Ingredient> inventory) {
        this.inventory = inventory;
    }



    @Override
    public String toString() {
        return this.inventory.keySet().toString();    }
 
    public Ingredient getIngredient(String name) {
        return this.inventory.get(name);
    }

    public void updatePantryWithAnotherPantryOrInventory(HashMap<String, Ingredient> entries) {
        HashMap<String, Ingredient> currentPantry = this.inventory;
        List<String> ingredientsToUpdate = entries.keySet().stream().toList();
        int numberOfIngredientsToUpdate = entries.size();
        for (int i = 0; i < numberOfIngredientsToUpdate; i ++){
            String iterationIngredientName = ingredientsToUpdate.get(i);
            if (currentPantry.containsKey(iterationIngredientName)){
                HashMap<String, Double> updatedAmount = entries.get(iterationIngredientName).getType();
                currentPantry.get(iterationIngredientName).setAmountFromExistingIngredients(updatedAmount);}
            else {
                this.inventory.put(iterationIngredientName, entries.get(iterationIngredientName));
            }
        }
         
    }
}



