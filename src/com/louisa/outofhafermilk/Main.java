package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;


import static com.louisa.outofhafermilk.ReadFile.readFile;

public class Main {


    public static void main(String[] args){

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";
        Pantry testPantry = new Pantry(defaultPantryFilePath);
        Logger.logNow(testPantry.toString());
        Pantry shoppingTrip = new Pantry(shoppingTripFilePath);
        testPantry.updatePantryWithAnotherPantryOrInventory(shoppingTrip.getInventory());
        Logger.logNow(testPantry.toString());
        Logger.logLater(testPantry.toString());


        }



    }


