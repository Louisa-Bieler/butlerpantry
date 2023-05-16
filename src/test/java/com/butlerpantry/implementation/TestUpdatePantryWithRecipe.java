package com.butlerpantry.implementation;

import com.butlerpantry.logging.Logger;
import org.junit.jupiter.api.Test;


import java.io.File;

public class TestUpdatePantryWithRecipe {


    @Test
    public void testUpdatePantryWithRecipe() throws Exception {
        //filePaths to .csv files used for data persistence
        String defaultPantryFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/src/test/resources/myPantry.csv";
        String shoppingTripFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/shoppingList.csv";
        String unitConversionsFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/unitConversions.csv";
        String recipeFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/src/test/resources/recipe.csv";

        //File objects created from csv files
        File testFile = ReadFile.readFile(defaultPantryFilePath);
        File shoppingTripFile = ReadFile.readFile(shoppingTripFilePath);
        UnitConversion.addUnitConversionMapping(unitConversionsFilePath);
        File recipeFile = ReadFile.readFile(recipeFilePath);

        //Pantry Objects for Test
        Pantry myPantry = PantryLogic.producePantryFromFile(testFile);
        Logger.logNow(myPantry.toString());
        Pantry recipe = PantryLogic.producePantryFromFile(recipeFile);
        Logger.logNow((recipe.toString()));

        if (PantryLogic.checkRecipeAgainstPantry(myPantry, recipe)){
            PantryLogic.subtractRecipeFromPantry(myPantry, recipe);
        }
        Logger.logNow(myPantry.toString());
        
    }
}
