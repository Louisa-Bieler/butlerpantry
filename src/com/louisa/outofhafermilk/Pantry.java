package com.louisa.outofhafermilk;


import com.louisa.logging.Logger;

import java.io.File;
import java.util.*;
import java.lang.Double;
import java.lang.String;


public class Pantry {
    private HashMap<String, Ingredient> inventory;

    public Pantry(File pantryFile) {
        Pantry newPantry = PantryFactory.producePantryFromFile(pantryFile);
        this.inventory = newPantry.inventory;
    }

    public Pantry(HashMap<String, Ingredient> inventory) {
        this.inventory = inventory;
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

    public void setIngredientFromString(String name, String unit, Double amount) {
        if (this.inventory.containsKey(name)) {
            this.inventory.get(name).setAmountFromScratch(unit, amount);
        } else {
            this.inventory.put(name, Ingredient.IngredientFactory.returnIngredient((name + "," + unit + "," + amount.toString())));
        }
    }

    public void setIngredientFromIngredient(Ingredient ingredientToAdd) {
        if (this.inventory.containsKey(ingredientToAdd.getName())) {
            this.inventory.get(ingredientToAdd.getName()).addAmountFromShopping(ingredientToAdd.getUnitAmount());
        } else {
            this.inventory.put(ingredientToAdd.getName(), ingredientToAdd);
        }
    }

    public void removeEntireIngredient(String name) {
        this.inventory.remove(name);
    }

    public void replaceIngredient(Ingredient replacement) {
        this.inventory.replace(replacement.getName(), replacement);
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

    public static class PantryFactory {

        public static Pantry producePantryFromFile(File defaultPantryFile) {
            Pantry newPantry = new Pantry();
            try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
                while (scanner.hasNextLine()) {
                    Ingredient iterIngredient = Ingredient.IngredientFactory.returnIngredient(scanner.nextLine());
                    newPantry.setIngredientFromIngredient(iterIngredient);

                }
                return newPantry;
            } catch (Exception e) {
                Logger.logLater(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}





