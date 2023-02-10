package com.louisa.outofhafermilk;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

import static com.louisa.outofhafermilk.ReadFile.readFile;



public class Pantry {
    public String defaultPantryFilePath;
    private File testFile;
    private ArrayList<Ingredient> inventory;


    public Pantry(String defaultPantryFilePath) {
        this.defaultPantryFilePath = defaultPantryFilePath;
        this.testFile  = readFile(defaultPantryFilePath);
        this.inventory = com.louisa.outofhafermilk.ProducePantryListFromFile.produceIngredients(testFile);
    }

    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }


    public void setInventory(ArrayList<Ingredient> inventory) {
        this.inventory = inventory;
    }

    public Ingredient getIngredient(int indexValue){
        return this.inventory.get(indexValue);
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


    }




