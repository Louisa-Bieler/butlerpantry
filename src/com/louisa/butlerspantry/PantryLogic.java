package com.louisa.butlerspantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PantryLogic {

    public static Pantry createPantryFromFile(File fileObject){
        Pantry newPantry = new Pantry();
        try (Scanner scanner = new Scanner(fileObject).useDelimiter(",")) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                String name = lineParts[0];
                String unit = lineParts[1];
                Double amount = Double.parseDouble(lineParts[2]);
                newPantry.setIngredient(name, unit, amount);
                }
        } catch(Exception e){
                Logger.logLater(e.getMessage());
                throw new RuntimeException(e);
            }
        return newPantry;
    }

    /*public Pantry createShoppingList(Pantry recipe, Pantry pantry) {
        Pantry shoppingList = new Pantry();
        HashMap<String, HashMap<String, Double>> tempRecipe = new HashMap<>(recipe.getInventory());
        if (tempRecipe.keySet().removeAll(pantry.getInventory().keySet())){
            shoppingList.setInventory(tempRecipe);
            recipe.getInventory().keySet().removeAll(shoppingList.getInventory().keySet());
        }
        recipe.getInventory().forEach(
                (ingredientName, hashMapUnitAmount) ->
                {
                    if (hashMapUnitAmount)
                }
        );




    }

    public void updatePantryFromFile(File fileObject, Pantry pantry){

    }*/

}
