package com.louisa.outofhafermilk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {


    public static void createUpdatedCSV(Pantry updatedPantry, String newFilename){
        File updatedCsv = new File(newFilename);
        String message = updatedPantry.toString();
        try (FileWriter fw = new FileWriter(updatedCsv)){
            for (int i = 0; i < message.length(); i++)
                fw.write(message.charAt(i));
    } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void createShoppingList(String shoppingList, String newFilename){
        File shoppingListFile = new File(newFilename);
        String message = shoppingList;
        try (FileWriter fw = new FileWriter(shoppingListFile)){
            for (int i = 0; i < message.length(); i++)
                fw.write(message.charAt(i));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
