package com.louisa.outofhafermilk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Pantry {

    private ArrayList<Ingredient> inventory = new ArrayList<>();

    public Pantry(){
        File myPantry = new File("myPantry.csv");
        ArrayList<Ingredient> pantry = new ArrayList<Ingredient>();
        try (Scanner scanner = new Scanner(myPantry).useDelimiter(",")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split(",");
                double amounts = Double.parseDouble(lineParts[2]);
                pantry.add(new Ingredient(lineParts[0], lineParts[1], amounts));

            }
            System.out.println(pantry.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        }


    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Ingredient> inventory) {
        int length = this.inventory.stream().count();
        int count;
        for (count=0, count<length, count++){
            inventory;
        }
    }
}
