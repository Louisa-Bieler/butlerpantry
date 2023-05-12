package com.butlerpantry.main;

import java.io.File;
import java.io.IOException;

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












        }



    }


