package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.Scanner;

public class PantryFactory {

    public static Pantry producePantryFromFile(File defaultPantryFile) {
        Pantry newPantry = new Pantry();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                Ingredient iterIngredient = IngredientFactory.returnIngredient(scanner.nextLine());
                String unitName = iterIngredient.getUnits().get(0);
                newPantry.setIngredient(iterIngredient.getName(), unitName, iterIngredient.getAmount(unitName));
            }
            return newPantry;
        } catch (Exception e) {
            Logger.logLater(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
