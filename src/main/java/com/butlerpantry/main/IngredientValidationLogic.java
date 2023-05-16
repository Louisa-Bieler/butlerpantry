package com.butlerpantry.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.*;

public class IngredientValidationLogic {

    public static void ingredientNameValidator(String name) throws IllegalArgumentException {

        if (name.isEmpty()){
            throw new IllegalArgumentException("Ingredient name is blank. Check input!");
        } else if (name.equals(null)){
            throw new IllegalArgumentException("Ingredient name was null. Check input!");
        } else if (name.matches("\\d+")) {
            throw new IllegalArgumentException("Ingredient name can not be a number. Check input!");
        } else if (!(name.matches("[a-zA-Z]+"))) {
            throw new IllegalArgumentException("Ingredient name contains no letters. Check input!");
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
