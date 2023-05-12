package main;

import com.butlerpantry.logging.Logger;
import com.butlerpantry.main.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(2000));


        @Test
        void testSetAmountHappyPath() {
            testIngredient.setAmount(BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000), testIngredient.getAmount());
        }

        @Test
        void testSetAmountNegativeNumber() {
            IllegalArgumentException badAmountException = assertThrows(IllegalArgumentException.class, () -> {
                testIngredient.setAmount(BigDecimal.valueOf(-1000));
            });
        }

        @Test
        public void testAddAmountFromShopping() {
            Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(1000));
            testIngredient.addAmountFromShopping(BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(1500).setScale(2), testIngredient.getAmount());
        }


        @Test
        public void testAddAmountFromShoppingWhenAmountIsNegative() {
            IllegalArgumentException negativeNumber = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                testIngredient.addAmountFromShopping(BigDecimal.valueOf(-500));
            });
            Logger.logNow(negativeNumber.getMessage());

        }

        @Test
        void subtractAmountFromRecipeHappyPath() {
            testIngredient.subtractAmountFromRecipe(BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(1500.00).setScale(2), testIngredient.getAmount());
        }

        @Test
        public void testSubtractAmountFromRecipeWhenAmountIsNegative() {
            IllegalArgumentException negativeNumber = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                testIngredient.subtractAmountFromRecipe(BigDecimal.valueOf(-500));
            });
            Logger.logNow(negativeNumber.getMessage());

        }

        @Test
        void testToString() {

        }
    }
