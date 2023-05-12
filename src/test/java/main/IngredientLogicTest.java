package main;


import com.butlerpantry.main.Ingredient;
import com.butlerpantry.main.IngredientLogic;
import com.butlerpantry.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientLogicTest {

    @Test
    void testReturnIngredientHappyPath() throws Exception {
        String happyPathIngredientString = "Flour,g,1000";
        Ingredient testIngredient = IngredientLogic.returnIngredient(happyPathIngredientString);
        String testIngredientToString = testIngredient.toString();
        assertTrue(testIngredientToString.contains(happyPathIngredientString));
    }

    @Test
    void testReturnIngredientBadString(){
        String badString = "5.0,Sz||\\\\,glory";
        Exception badStringException = assertThrows(Exception.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient(badString);
        });
        String expectedMessage = "glory";
        String actualMessage = badStringException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void testReturnIngredientNegativeAmount() {
            IllegalArgumentException badAmountException = assertThrows(IllegalArgumentException.class, () -> {
            Ingredient willNotCome = IngredientLogic.returnIngredient("Flour,g,-1000");
        });
        Logger.logNow(badAmountException.getMessage());
    }

    @Test
    void testBadPathNoInput() {
        Exception unknownException = assertThrows(Exception.class, () -> {
            Ingredient failure = IngredientLogic.returnIngredient(",");
        });
        Logger.logNow(unknownException.getMessage() + "\n"  + unknownException.getClass());

    }

    @Test
    void testBadPathNoStringsAndABigDecimal() {
        Exception unknownException = assertThrows(Exception.class, () -> {
            Ingredient failure = IngredientLogic.returnIngredient(",,3");
        });
        Logger.logNow(unknownException.getMessage() + "\n"  + unknownException.getClass());
    }


}