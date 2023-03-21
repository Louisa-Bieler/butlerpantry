package com.louisa.butlerpantry;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.String;


public class Pantry {
    private HashMap<String, Ingredient> inventory;

    public Pantry(File pantryFile) throws IOException {
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

    public Ingredient getIngredient(String ingredientKey) {
        return this.inventory.get(ingredientKey);
    }

}





