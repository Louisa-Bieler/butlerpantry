package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Double;
import java.lang.String;
import java.util.Set;

public class ProduceIngredientHashMapFromFile {
//Figure out how to do a hash map with the key as the combo of name and unit

    public static HashMap<String, Ingredient> produceIngredients(File defaultPantryFile) {
        HashMap<String, Ingredient> myPantry = new HashMap<>();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                String name = lineParts[0];
                String unit = lineParts[1];
                Double amount = Double.parseDouble(lineParts[2]);
                if (myPantry.containsKey(name)) {
                    myPantry.get(name).setAmount(unit, amount);
                } else {
                    myPantry.put(name, new Ingredient(name, unit, amount));
                }
            }
            return myPantry;
        } catch (Exception e) {
            Logger.logLater(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}


