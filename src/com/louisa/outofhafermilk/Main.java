package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.louisa.outofhafermilk.ReadFile.readFile;

public class Main {


    public static void main(String[] args) throws IOException {

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";

        File testFile = readFile(defaultPantryFilePath);
        File shoppingTripFile = readFile(shoppingTripFilePath);

        UnitConversion.loadConversionHashMaps();

        Pantry testPantry = PantryLogic.producePantryFromFile(testFile);
        Pantry otherRecipe = PantryLogic.producePantryFromFile(testFile);
        Logger.logNow("testPantry:\n" + (testPantry.toString()));
        Pantry recipe = PantryLogic.producePantryFromFile(shoppingTripFile);
        Logger.logNow("recipe:\n" + (recipe.toString()));
        Pantry shoppingList = PantryLogic.updatePantryWithRecipe(testPantry, recipe);
        Logger.logNow("TestPantry after recipeupdate: \n" + testPantry);
        Logger.logNow("shoppingList:\n" + shoppingList);
        PantryLogic.addShopping(testPantry, shoppingList);
        Logger.logNow("other Recipe:\n" + otherRecipe);
        PantryLogic.updatePantryWithRecipe(testPantry, otherRecipe);
        Logger.logNow("testPantry:\n" + testPantry);







        }



    }


