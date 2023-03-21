package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PantryLogic {

    public static Pantry producePantryFromFile(File defaultPantryFile) throws IOException {
        Pantry newPantry = new Pantry();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                Ingredient iterIngredient = IngredientLogic.returnIngredient(scanner.nextLine());
                newPantry.setIngredientFromIngredient(iterIngredient);

            }
            return newPantry;
        } catch (IOException e) {
            Logger.logLater(e.getMessage());
            throw new IOException(e);
        }
    }

    public static boolean checkRecipeAgainstPantry(Pantry toUpdate, Pantry recipe) {
        Pantry shoppingList = new Pantry();
        recipe.getInventory().forEach(
                (recipeIngredientKey, recipeIngredient) ->
                {
                    if(!toUpdate.getInventory().keySet().contains(recipeIngredientKey)){
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    } else if (toUpdate.getIngredient(recipeIngredientKey).getAmount()>recipeIngredient.getAmount()) {
                        return;
                    } else if (toUpdate.getIngredient(recipeIngredientKey).getAmount().equals(recipeIngredient.getAmount())) {
                        return;
                    } else {
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    }
                }
        );
        if (shoppingList.getInventory().isEmpty()){
            return true;
        } else {
            WriteFile.createUpdatedCSV(shoppingList, "shoppingList.csv");
            return false;
        }

    }

    public static void subtractPrecheckedRecipeFromPantry(Pantry toUpdate, Pantry recipe){
        recipe.getInventory().forEach(
                (recipeIngredientKey, recipeIngredient) ->
                { if (toUpdate.getIngredient(recipeIngredientKey).getAmount()>recipeIngredient.getAmount()) {
                    toUpdate.getIngredient(recipeIngredientKey).subtractAmountFromRecipe(recipeIngredient.getAmount());
                } else {
                    toUpdate.removeEntireIngredient(recipeIngredientKey);
                }

    });
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
