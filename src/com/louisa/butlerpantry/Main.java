package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.louisa.butlerpantry.ReadFile.readFile;

public class Main {


    public static void main(String[] args) throws IOException {


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

        Logger.logNow("TestPantry after recipeupdate: \n" + testPantry);









        }



    }


