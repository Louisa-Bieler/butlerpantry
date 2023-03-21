package com.louisa.test;

import com.louisa.butlerpantry.Pantry;
import com.louisa.butlerpantry.PantryLogic;
import com.louisa.butlerpantry.ReadFile;
import com.louisa.butlerpantry.UnitConversion;
import com.louisa.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class UpdatePantryWithRecipe {


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


        //Pantry objects to test logic
        Pantry testPantry = PantryLogic.producePantryFromFile(testFile);
        Double preValue = testPantry.getIngredient("breadpiece").getAmount();
        Pantry recipe = PantryLogic.producePantryFromFile(recipeFile);
        Pantry shoppingTrip = PantryLogic.producePantryFromFile(shoppingTripFile);

        //using Pantry objects to test PantryLogic method updatePantryWithRecipe
        boolean shoppingListTrue = PantryLogic.checkRecipeAgainstPantry(testPantry, recipe);
        if (shoppingListTrue == false) {
            PantryLogic.addShopping(testPantry, shoppingTrip);
        }
        PantryLogic.subtractPrecheckedRecipeFromPantry(testPantry, recipe);
        Double recipeValue = recipe.getIngredient("breadpiece").getAmount();
        Double finalState = testPantry.getIngredient("breadpiece").getAmount();
        Assertions.assertTrue(finalState.equals(preValue - recipeValue));

    }
}
