package com.louisa.outofhafermilk;

import java.io.File;
import java.util.HashMap;
import java.lang.Double;
import java.lang.String;
import java.util.ArrayList;

import static com.louisa.outofhafermilk.ReadFile.readFile;



public class Pantry {
    public String defaultPantryFilePath;
    private File testFile;
    private HashMap<String, Double> inventory;


    public Pantry(String defaultPantryFilePath) {
        this.defaultPantryFilePath = defaultPantryFilePath;
        this.testFile  = readFile(defaultPantryFilePath);
        this.inventory = ProduceIngredientArrayListFromFile.produceIngredients(testFile);
    }

    public java.util.HashMap<java.lang.String, java.lang.Double> getInventory() {
        return inventory;
    }


    public void setInventory(HashMap<String, Double> inventory) {
        this.inventory = inventory;
    }

    public Ingredient getIngredient(String key){
         Set ingredientValue = this.inventory.entrySet();



    }

    @Override
    public String toString() {
        ArrayList<String> inventoryString = new ArrayList<>();
        int count = this.inventory.size();
        int i = 0;
        while (i < count) {
            inventoryString.add(this.getIngredient(i).toString());
            i++;
        }
        return inventoryString.toString();
    }


    public static interface IngredientMatcher {

        public int I
    }

    public static class UpdatePantry {
    }
}




