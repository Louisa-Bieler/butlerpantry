package com.louisa.butlerpantry;

import com.louisa.logging.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.louisa.butlerpantry.UnitConversion.*;

public class IngredientLogic {

    public static Ingredient returnIngredient(String record) {

        try {
            String[] recordFields = record.split(",");
            String[] conversionUnits = unitConversion(record);
            String name = recordFields[0];
            String unit;
            BigDecimal amount;
            if (conversionUnits == null) {
                unit = recordFields[1];
                amount = BigDecimal.valueOf(Long.parseLong(recordFields[2]));
            } else {
                unit = conversionUnits[0];
                amount = BigDecimal.valueOf(Double.parseDouble(recordFields[2]) * Double.parseDouble(conversionUnits[1])).setScale(3, RoundingMode.HALF_UP);
            }
            return new Ingredient(name, unit, amount);
        } catch (IllegalArgumentException wrongNumber) {
            Logger.logNow(wrongNumber.getMessage());
            throw wrongNumber;
        } catch (Exception e) {
            throw e;
        }
    }
}