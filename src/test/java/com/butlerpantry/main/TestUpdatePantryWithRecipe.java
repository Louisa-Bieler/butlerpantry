package com.butlerpantry.main;

import com.butlerpantry.main.Pantry;
import com.butlerpantry.main.PantryLogic;
import com.butlerpantry.main.ReadFile;
import com.butlerpantry.main.UnitConversion;
import org.junit.jupiter.api.Test;


import java.io.File;

public class TestUpdatePantryWithRecipe {


    @Test
    public void testUpdatePantryWithRecipe() throws Exception {
        //filePaths to .csv files used for data persistence
        String defaultPantryFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/myPantry.csv";
        String shoppingTripFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/shoppingList.csv";
        String unitConversionsFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/unitConversions.csv";
        String recipeFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/recipe.csv";

        //File objects created from csv files
        File testFile = ReadFile.readFile(defaultPantryFilePath);
        File shoppingTripFile = ReadFile.readFile(shoppingTripFilePath);
        UnitConversion.addUnitConversionMapping(unitConversionsFilePath);
        File recipeFile = ReadFile.readFile(recipeFilePath);

        //Pantry Objects for Test
        Pantry myPantry = PantryLogic.producePantryFromFile(testFile);
        Pantry recipe = PantryLogic.producePantryFromFile(recipeFile);

        if (PantryLogic.checkRecipeAgainstPantry(myPantry, recipe)){
            PantryLogic.subtractRecipeFromPantry(myPantry, recipe);
        }
    }
}
