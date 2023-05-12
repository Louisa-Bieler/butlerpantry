package com.butlerpantry.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IngredientValidationLogic {

    public static void ingredientNameValidator(String name) throws IllegalArgumentException {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Ingredient name is blank. Check input!");
        }
    }

    public static void ingredientUnitValidator(String unit) throws IllegalArgumentException {
        if (unit.isEmpty()){
            throw new IllegalArgumentException("Ingredient unit is blank. Check input!");
        }
    }

    public static void ingredientAmountValidator(BigDecimal amount) throws IllegalArgumentException {
        if (amount.compareTo(BigDecimal.valueOf(0))<0) {
            throw new IllegalArgumentException("Input amount cannot be a negative number");
        }
    }

}
