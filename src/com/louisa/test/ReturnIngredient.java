package com.louisa.test;
import com.louisa.butlerpantry.Ingredient;
import com.louisa.butlerpantry.IngredientLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReturnIngredient {

    @Test
    public void testReturnIngredientBadStringDouble(){
        String badString = "5.0,Sz||\\\\,glory";
        Exception badStringException = assertThrows(Exception.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient(badString);
        });
        String expectedMessage = "For input string: \"glory\"";
        String actualMessage = badStringException.getMessage();

         assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testReturnIngredientBadStringEscape() {
        String badString = "5.0,Sz|\\,glory";
        Exception badStringException = assertThrows(Exception.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient(badString);
        });
        String expectedMessage = "does it";
        String actualMessage = badStringException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
