package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class PantryLogic {

    public static Pantry producePantryFromFile(File defaultPantryFile) throws IOException {
        Pantry newPantry = new Pantry(defaultPantryFile.getName());
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

    private static boolean checkRecipeAgainstPantry(Pantry toUpdate, Pantry recipe) {
        return (toUpdate.getInventory().keySet().containsAll(recipe.getInventory().keySet()));
    }

    private static Pantry createShoppingList(Pantry toUpdate, Pantry recipe) {
        Pantry shoppingList = new Pantry(recipe.getName() + Date.from(Instant.now()));
        recipe.getInventory().forEach(
                (recipeIngredientKey, recipeIngredient) ->
                {
                    if (!toUpdate.getInventory().keySet().contains(recipeIngredientKey)) {
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    } else if (toUpdate.getIngredient(recipeIngredientKey).getAmount().compareTo(recipeIngredient.getAmount()) == 1) {
                        return;
                    } else if (toUpdate.getIngredient(recipeIngredientKey).getAmount().equals(recipeIngredient.getAmount())) {
                        return;
                    } else {
                        shoppingList.setIngredientFromIngredient(recipeIngredient);
                    }
                }
        );
        return shoppingList;
    }

    private static void subtractRecipeFromPantry(Pantry toUpdate, Pantry recipe) {
        recipe.getInventory().forEach(
                (recipeIngredientKey, recipeIngredient) ->
                {
                    if (toUpdate.getIngredient(recipeIngredientKey).getAmount().compareTo(recipeIngredient.getAmount()) == 1) {
                        toUpdate.getIngredient(recipeIngredientKey).subtractAmountFromRecipe(recipeIngredient.getAmount());
                    } else {
                        toUpdate.removeEntireIngredient(recipeIngredientKey);
                    }
                }
        );
    }

    public static void addRecipeIfPossibleCreateShoppingListIfNot(Pantry toUpdate, Pantry recipe) {
        if (!checkRecipeAgainstPantry(toUpdate, recipe)) {
            Pantry shoppingList = createShoppingList(toUpdate, recipe);
            WriteFile.writeShoppingListToCSV(shoppingList.toString(), shoppingList.getName());
        } else {
            subtractRecipeFromPantry(toUpdate, recipe);
        }
    }

        public static void addShopping (Pantry toUpdate, Pantry entries){
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

