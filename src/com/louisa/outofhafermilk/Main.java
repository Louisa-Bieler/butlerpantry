package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.louisa.outofhafermilk.ProduceIngredientArrayListFromFile.produceIngredients;
import static com.louisa.outofhafermilk.ReadFile.readFile;

public class Main {


    public static void main(String[] args){

        String defaultPantryFilePath = args[0];
        Pantry testPantry = new Pantry(defaultPantryFilePath);
        Logger.logNow(testPantry.toString());
        Logger.logLater(testPantry.toString());
        Logger.logLater(testPantry.toString());
        Logger.logNow(testPantry.getInventory().get(0).toString());


    }


}