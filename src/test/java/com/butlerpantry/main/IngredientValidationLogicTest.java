package com.butlerpantry.main;

import com.butlerpantry.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class IngredientValidationLogicTest {

    final String emptyTestString = "";
    final String nullTestString = null;
    final BigDecimal nullBigDecimal = null;
    final int notABigD = 0;
    final BigDecimal randomNegativeBigD = BigDecimal.valueOf(-1.00);


    @Test
    void ingredientNameValidatorHappyPath() {
        IllegalArgumentException emptyName = assertThrows(IllegalArgumentException.class, () -> {
            IngredientValidationLogic.ingredientNameValidator(emptyTestString);
        });
    }

    @Test
    void ingredientNameValidatorJustComma() {
        Exception unknownException = assertThrows(Exception.class, () -> {
            Ingredient failure = IngredientLogic.returnIngredient(",");
            IngredientValidationLogic.ingredientNameValidator(failure.getName());
            });
            Logger.logNow(unknownException.getMessage() + "\n"  + unknownException.getClass());
        }

    @Test
    void ingredientNameValidatorJustNumbers() {
        IllegalArgumentException justNumbers = assertThrows(IllegalArgumentException.class, () -> {
            Ingredient failure = IngredientLogic.returnIngredient("057389,g,1000");
            IngredientValidationLogic.ingredientNameValidator(failure.getName());
        });
        Logger.logNow(justNumbers.getMessage() + "\n"  + justNumbers.getClass());
    }

    @Test
    void ingredientNameValidatorNumbersAndLetters() {
        Ingredient success = IngredientLogic.returnIngredient("057383asd,g,1000");
        Assertions.assertEquals("057383asd", success.getName());
        }

    @Test
    void ingredientNameValidatorNoLetters() {
        IllegalArgumentException noLetters = assertThrows(IllegalArgumentException.class, () -> {
            Ingredient onlySymbols = IngredientLogic.returnIngredient("§$(/?,g,1000");
            IngredientValidationLogic.ingredientNameValidator(onlySymbols.getName());
        });
        Logger.logNow(noLetters.getMessage() + "\n"  + noLetters.getClass());
    }

    @Test
    void ingredientUnitValidator() {
    }

    @Test
    void ingredientAmountValidatorHappyPath() {
        Ingredient success = IngredientLogic.returnIngredient("057383asd,g,1000.453");
        assertEquals(BigDecimal.valueOf(1000.45).setScale(2), success.getAmount());
    }

    @Test
    void ingredientAmountValidatorNegativeAmount() {
        IllegalArgumentException badAmountException = assertThrows(IllegalArgumentException.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient("Flour,g,-1000");
            IngredientValidationLogic.ingredientAmountValidator(willNotCome.getAmount());
        });
        Logger.logNow(badAmountException.getMessage());
    }

}