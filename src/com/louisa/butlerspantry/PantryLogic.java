package com.louisa.butlerspantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.util.Scanner;

public class PantryLogic {

    public static Pantry createPantryFromFile(File fileObject){
        Pantry newPantry = new Pantry();
        try (Scanner scanner = new Scanner(fileObject).useDelimiter(",")) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                String name = lineParts[0];
                String unit = lineParts[1];
                Double amount = Double.parseDouble(lineParts[2]);
                newPantry.setIngredient(name, unit, amount);
                }
        } catch(Exception e){
                Logger.logLater(e.getMessage());
                throw new RuntimeException(e);
            }
        return newPantry;
    }

    public Pantry createShoppingList(Pantry recipe, Pantry pantry) {
        return null;
    }

    public void updatePantryFromFile(File fileObject, Pantry pantry){

    }


    public File createFileObjectFromPantry(Pantry pantry){
        return null;
    }
}
