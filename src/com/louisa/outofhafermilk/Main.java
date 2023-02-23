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

        Pantry testPantry = Pantry.PantryFactory.producePantryFromFile(testFile);
        Logger.logNow("testPantry" + (testPantry.toString()));
        Pantry recipe = Pantry.PantryFactory.producePantryFromFile(shoppingTripFile);
        Logger.logNow("recipe" + (recipe.toString()));
        Pantry shoppingList = testPantry.updatePantryWithRecipe(recipe);
        Logger.logNow("TestPantry after recipeupdate" + testPantry.toString());
        Logger.logNow("shoppingList" + shoppingList.toString());
        testPantry.addShopping(shoppingList);
        Logger.logNow("testPantry" + testPantry.toString());







        }



    }


