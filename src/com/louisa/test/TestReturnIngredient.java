package com.louisa.test;
import com.louisa.butlerpantry.Ingredient;
import com.louisa.butlerpantry.IngredientLogic;
import com.louisa.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestReturnIngredient {

    @Test
    public void testReturnIngredientBadStringDouble(){
        String badString = "5.0,Sz||\\\\,glory";
        Exception badStringException = assertThrows(Exception.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient(badString);
        });
        String expectedMessage = "glory";
        String actualMessage = badStringException.getMessage();

         assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testReturnIngredientBadStringEscape() {
        String badString = "5.0,Sz|\\,glory";
        Exception badStringException = assertThrows(Exception.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient(badString);
        });
        String expectedMessage = "glory";
        String actualMessage = badStringException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testReturnIngredientNegativeAmount() {
        IllegalArgumentException badAmountException = assertThrows(IllegalArgumentException.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient("Flour,g,-1000");
        });
        Logger.logNow(badAmountException.getMessage());
    }

}
