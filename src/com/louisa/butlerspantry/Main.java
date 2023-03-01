package com.louisa.butlerspantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;

import static com.louisa.butlerspantry.PantryLogic.createPantryFromFile;
import static com.louisa.butlerspantry.ReadFile.readFile;

public class Main {


    public static void main(String[] args) throws IOException {

        String defaultPantryFilePath = "myPantry.csv";
        String shoppingTripFilePath = "shoppingTrip.csv";

        File testFile = readFile(defaultPantryFilePath);
        File shoppingTripFile = readFile(shoppingTripFilePath);

        Pantry pantryTest = createPantryFromFile(testFile);
        Logger.logNow(pantryTest.toString());









        }




}


