package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;

import static com.louisa.outofhafermilk.ReadFile.readFile;

public class Main {


    public static void main(String[] args) throws IOException {

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";

        File testFile = readFile(defaultPantryFilePath);
        File shoppingTripFile = readFile(shoppingTripFilePath);

        Pantry testPantry = PantryLogic.producePantryFromFile(testFile);
        Logger.logNow("testPantry:\n" + (testPantry.toString()));
        Pantry recipe = PantryLogic.producePantryFromFile(shoppingTripFile);
        Logger.logNow("recipe:\n" + (recipe.toString()));
        Pantry shoppingList = PantryLogic.updatePantryWithRecipe(testPantry, recipe);
        Logger.logNow("TestPantry after recipeupdate: \n" + testPantry);
        Logger.logNow("shoppingList:\n" + shoppingList);
        PantryLogic.addShopping(testPantry, shoppingList);
        Logger.logNow("testPantry:\n" + testPantry);







        }



    }


