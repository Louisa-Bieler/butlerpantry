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


    /*public Pantry updatePantryWithRecipe(Pantry recipe) {
        this.inventory.forEach(
                , ());HashMap<String, Ingredient> currentPantry = this.getInventory();
        List<String> ingredientsToUpdate = recipe.inventory.keySet().stream().collect(Collectors.toList());
        Pantry shoppingList = new Pantry(recipe.getInventory());
        int numberOfIngredientsToUpdate = ingredientsToUpdate.size();
        for (int i = 0; i < numberOfIngredientsToUpdate; i++) {
            String iterationIngredientName = ingredientsToUpdate.get(i);
            String recipeUnitName = recipe.getIngredient(iterationIngredientName).getUnits().get(0);
            if (currentPantry.containsKey(iterationIngredientName)) {
                Ingredient updatedIngredient = this.getIngredient(iterationIngredientName);
                updatedIngredient.setAmountFromRecipe(recipe.getIngredient(iterationIngredientName));
                if (updatedIngredient.getAmount(recipeUnitName) == 0){
                    if (this.getIngredient(iterationIngredientName).getUnits().size() > 1){
                        this.getIngredient(iterationIngredientName).removeUnit(recipeUnitName);
                    } else {
                        this.removeEntireIngredient(iterationIngredientName);
                    }
                    shoppingList.replaceIngredient(updatedIngredient);
                } else if (updatedIngredient.getAmount(recipeUnitName) > 0) {
                    this.replaceIngredient(updatedIngredient);
                    shoppingList.removeEntireIngredient(iterationIngredientName);
                } else {
                    shoppingList.replaceIngredient(updatedIngredient);
                }
            } else {
                Ingredient shoppingIngredient = recipe.getIngredient(iterationIngredientName);
                Double newValue = shoppingIngredient.getAmount(recipeUnitName) * -1;
                shoppingIngredient.setAmountFromScratch(recipeUnitName, newValue);
                shoppingList.replaceIngredient(shoppingIngredient);
            }
        }
        Logger.logNow(shoppingList.toString());
        return shoppingList;
    }*/

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





