package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Double;
import java.lang.String;

public class ProduceIngredientArrayListFromFile {
//Figure out how to do a hash map with the key as the combo of name and unit

    public static HashMap<String, Double> produceIngredients(File defaultPantryFile) {
        HashMap<String, Double> myPantry = new HashMap<>();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                Double amounts = Double.parseDouble(lineParts[2]);
                myPantry.put(new Ingredient(lineParts[0].format("%s ",lineParts[0]) + lineParts[1], amounts));
            }
            return myPantry;
        } catch (Exception e) {
            Logger.logLater(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static class UnitConversions {
    }
}

