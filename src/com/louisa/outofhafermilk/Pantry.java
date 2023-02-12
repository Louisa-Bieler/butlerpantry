package com.louisa.outofhafermilk;

import java.io.File;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.lang.Double;
import java.lang.String;
import java.util.ArrayList;
import java.util.Set;

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
        ArrayList<String> inventoryString = new ArrayList<>();
        int count = this.inventory.size();
        int i = 0;
        while (i < count) {
            inventoryString.add(this.getIngredient(i).toString());
            i++;
        }
        return inventoryString.toString();
    }
 
    public Ingredient getIngredient(String name) {
        return this.inventory.get(name);
    }

    public static void updatePantryManual(HashMap<String, Ingredient> entries) {
        ArrayList<String> keys = (ArrayList<String>) entries.keySet();
        for (int i = 0; i<keys.size(); i++){
            String iterationKey = keys.get(i);
            if (this.inventory.containsKey(iterationKey){
                Ingredient toUpdate = this.inventory.get(iterationKey);
                ArrayList<String> unitToUpdateKeys = (ArrayList<String>)
                        toUpdate.getType().keySet()
                Ingredient upDated;
                for (int i = 0; i < entries.get(iterationKey).getAmount().size(); i++){

                } toUpdate.setAmount(entries.get(keys.get(i)).getType().);
                this.inventory.put(keys.get(i), entries.get(keys.get(i));
            }
        }
         
    }
}



