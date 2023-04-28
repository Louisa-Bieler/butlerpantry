package com.louisa.test;

import com.louisa.butlerpantry.ReadFile;
import com.louisa.butlerpantry.UnitConversion;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TestUpdatePantryWithRecipe {


    @Test
    public void testUpdatePantryWithRecipe() throws IOException {
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




    }
}
