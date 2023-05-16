package com.butlerpantry.implementation;

import com.butlerpantry.logging.Logger;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws Exception {

          //filePaths to .csv files used for data persistence
            String defaultPantryFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/src/test/resources/myPantry.csv";
            String shoppingTripFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/output/shoppingList.csv";
            String unitConversionsFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/input/unitConversions.csv";
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

            //WriteFile.createUpdatedCSV(myPantry);












        }



    }


