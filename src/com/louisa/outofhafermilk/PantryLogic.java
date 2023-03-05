package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.Scanner;

public class PantryLogic {

    public static Pantry producePantryFromFile(File defaultPantryFile) {
        Pantry newPantry = new Pantry();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                Ingredient iterIngredient = IngredientLogic.returnIngredient(scanner.nextLine());
                newPantry.setIngredientFromIngredient(iterIngredient);

            }
            return newPantry;
        } catch (Exception e) {
            Logger.logLater(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Pantry updatePantryWithRecipe(Pantry toUpdate, Pantry recipe) {
        Pantry shoppingList = new Pantry();
        recipe.getInventory().forEach(
                (recipeIngredientKey, recipeIngredient) ->
                {
                    if(!toUpdate.getInventory().keySet().contains(recipeIngredientKey)){
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    } else if (toUpdate.getInventory().get(recipeIngredientKey).getAmount()>recipeIngredient.getAmount()) {
                        toUpdate.getIngredient(recipeIngredientKey).subtractAmountFromRecipe(recipeIngredient.getAmount());
                    } else if (toUpdate.getInventory().get(recipeIngredientKey).getAmount()==recipeIngredient.getAmount()) {
                        toUpdate.removeEntireIngredient(recipeIngredientKey);
                    } else {
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    }
                }
        );
        return shoppingList;
    }

    public static void addShopping(Pantry toUpdate, Pantry entries) {
        entries.getInventory().forEach(
                (key, value) ->
                        toUpdate.getInventory().merge(
                                key, value, (value1, value2) ->
                                {
                                    value1.addAmountFromShopping(value2.getAmount());
                                    return value1;
                                }
                        )
        );
    }
}
