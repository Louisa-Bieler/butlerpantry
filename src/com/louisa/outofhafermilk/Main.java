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

        Pantry testPantry = PantryFactory.producePantryFromFile(testFile);
        Logger.logNow((testPantry.toString()));
        Pantry shoppingTrip = PantryFactory.producePantryFromFile(shoppingTripFile);

        testPantry.addShopping(shoppingTrip);
        Logger.logNow(testPantry.toString());





        }



    }


