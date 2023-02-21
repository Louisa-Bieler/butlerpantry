package com.louisa.outofhafermilk;

public class IngredientFactory {
//Figure out how to do a hash map with the key as the combo of name and unit


    public static Ingredient returnIngredient(String g) {

        String line = g;
        String[] lineParts = line.split(",");
        String name = lineParts[0];
        String unit = lineParts[1];
        Double amount = Double.parseDouble(lineParts[2]);
        Ingredient newIngredient  = new Ingredient(name, unit, amount);
        //if the unit is not in this list, then just go put it in
        //unless it has an empty character, or unacceptable type of string like lots of punctuation or digits or such
        //if it is in this list(maintained forced lower case list of possible iterations of weight or volume)
        //if a decaliter comes in we want to multply by the factor instead of dividing hence the factor should be a Double
        return newIngredient;

    }

}


