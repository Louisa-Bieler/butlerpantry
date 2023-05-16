package com.butlerpantry.main;

import com.butlerpantry.logging.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.butlerpantry.main.UnitConversion.*;

public class IngredientLogic {

    public static Ingredient returnIngredient(String record) {
            String[] recordFields = record.split(",");
            String[] conversionUnits = unitConversion(record);
            String name = recordFields[0];
            String unit;
            BigDecimal amount;
            if (conversionUnits == null) {
                unit = recordFields[1];
                amount = BigDecimal.valueOf(Double.parseDouble(recordFields[2])).setScale(2, RoundingMode.HALF_UP);
            } else {
                unit = conversionUnits[0];
                amount = BigDecimal.valueOf(Double.parseDouble(recordFields[2])).setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(Double.parseDouble(conversionUnits[1]))).setScale(2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
            }
            return new Ingredient(name, unit, amount);
    }
}