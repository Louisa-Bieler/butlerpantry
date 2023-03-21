package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import static com.louisa.butlerpantry.UnitConversion.*;

public class IngredientLogic {

    public static Ingredient returnIngredient(String g) {

        try {
            String line = g;
            String[] lineParts = line.split(",");
            String[] conversionUnits = unitConversion(line);
            String name;
            String unit;
            Double amount;
            if (conversionUnits==null) {
                name = lineParts[0];
                unit = lineParts[1];
                amount = Double.parseDouble(lineParts[2]);
            } else {
                name = lineParts[0];
                unit = conversionUnits[0];
                amount = Double.parseDouble(lineParts[2]) * Double.parseDouble(conversionUnits[1]);
            }
            Ingredient newIngredient  = new Ingredient(name, unit, amount);
            return newIngredient;
        } catch (Exception e) {
            Logger.logNow(e.getMessage());
            Logger.logLater("String "+ "\"" + g + "\"" + " could not be processed. Reason: " + e.getMessage());
            throw e;
        }
    }

}
