package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.louisa.outofhafermilk.UnitConversion.*;

public class IngredientLogic {

    public static Ingredient returnIngredient(String g) {

        try {
            String line = g;
            String[] lineParts = line.split(",");
            String name = lineParts[0];
            String unit = convertUnitName(lineParts[1]);
            Double amount = convertUnitAmount(unit, Double.parseDouble(lineParts[2]));
            String finalUnit = nonMetricUnits(unit);
            Ingredient newIngredient  = new Ingredient(name, finalUnit, amount);
            return newIngredient;
        } catch (Exception e) {
            Logger.logNow(e.getMessage());
            throw e;
        }
    }

}
