package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProducePantryListFromFile {

    public static ArrayList<Ingredient> produceIngredients(File defaultPantryFile) {
        ArrayList<Ingredient> myPantry = new ArrayList<>();
        try (Scanner scanner = new Scanner(defaultPantryFile).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                double amounts = Double.parseDouble(lineParts[2]);
                myPantry.add(new Ingredient(lineParts[0], lineParts[1], amounts));
            }
            return myPantry;
        } catch (Exception e) {
            Logger.logLater(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

