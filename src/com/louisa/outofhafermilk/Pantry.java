package com.louisa.outofhafermilk;


import com.louisa.logging.Logger;

import java.io.File;
import java.util.*;
import java.lang.Double;
import java.lang.String;


public class Pantry {
    private HashMap<String, Ingredient> inventory;

    public Pantry(File pantryFile) {
        Pantry newPantry = PantryLogic.producePantryFromFile(pantryFile);
        this.inventory = newPantry.inventory;
    }

    public Pantry() {
        this.inventory = new HashMap<String, Ingredient>();
    }

    public HashMap<String, Ingredient> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Ingredient> inventory) {
        this.inventory = inventory;
    }

    public void setIngredientFromIngredient(Ingredient ingredientToAdd) {
        if (this.inventory.containsKey(ingredientToAdd.getName()+ingredientToAdd.getUnit())) {
            this.inventory.get(ingredientToAdd.getName()+ingredientToAdd.getUnit()).addAmountFromShopping(ingredientToAdd.getAmount());
        } else {
            this.inventory.put(ingredientToAdd.getName()+ingredientToAdd.getUnit(), ingredientToAdd);
        }
    }

    public void removeEntireIngredient(String name) {
        this.inventory.remove(name);
    }

    public void replaceIngredient(Ingredient replacement) {
        this.inventory.replace(replacement.getName()+replacement.getUnit(), replacement);
    }

    @Override
    public String toString() {
        Iterator<Ingredient> ingredientIterator = this.inventory.values().iterator();
        StringBuilder sb = new StringBuilder();
        while (ingredientIterator.hasNext()) {
            sb.append(ingredientIterator.next().toString());
        }
        return sb.toString();
    }

    public Ingredient getIngredient(String name) {
        return this.inventory.get(name);
    }

}





