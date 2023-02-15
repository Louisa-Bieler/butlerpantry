package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

public class Main {


    public static void main(String[] args){

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";
        Pantry testPantry = new Pantry(defaultPantryFilePath);
        Logger.logNow(testPantry.toString());
        Pantry shoppingTrip = new Pantry(shoppingTripFilePath);
        testPantry.updatePantry(shoppingTrip.getInventory());
        Logger.logNow(testPantry.toString());
        WriteFile.createUpdatedCSV(testPantry, "updatedPantry.csv");



        }



    }


