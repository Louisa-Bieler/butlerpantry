package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;

import static com.louisa.butlerpantry.ReadFile.readFile;

public class Main {


    public static void main(String[] args) throws IOException {

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";

        File testFile = readFile(defaultPantryFilePath);
        File shoppingTripFile = readFile(shoppingTripFilePath);
        UnitConversion.addUnitConversionMapping("unitConversions.csv");
        File recipethree = readFile("recipe.csv");
        Pantry recipePantryThree = PantryLogic.producePantryFromFile(recipethree);


        Pantry testPantry = PantryLogic.producePantryFromFile(testFile);
        Pantry otherRecipe = PantryLogic.producePantryFromFile(testFile);
        Logger.logNow("testPantry:\n" + (testPantry.toString()));
        Pantry recipe = PantryLogic.producePantryFromFile(shoppingTripFile);
        Logger.logNow("recipe:\n" + (recipe.toString()));
        Pantry shoppingList = PantryLogic.updatePantryWithRecipe(testPantry, recipe);
        Logger.logNow("TestPantry after recipeupdate: \n" + testPantry);
        Logger.logNow("shoppingList:\n" + shoppingList);
        PantryLogic.addShopping(testPantry, shoppingList);
        Logger.logNow("test Pantry after shoppning: \n" + testPantry);
        Logger.logNow("other Recipe:\n" + otherRecipe);
        PantryLogic.updatePantryWithRecipe(testPantry, recipePantryThree);
        Logger.logNow("testPantry:\n" + testPantry);







        }



    }


