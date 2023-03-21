package com.louisa.test;
import com.louisa.butlerpantry.Ingredient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddAmountFromShopping {


    @Test
    public void testAddAmountFromShopping() {
        Ingredient testIngredient = new Ingredient("Flour", "g", 1000.0);
        testIngredient.addAmountFromShopping(500.0);
        assertEquals(1500.0, testIngredient.getAmount());
    }

    @Test
    public void testAddNegativeAmount() {
        Ingredient testIngredient = new Ingredient("Flour", "g", 50.0);
        testIngredient.addAmountFromShopping(-0.2);
        assertEquals(49.8, testIngredient.getAmount());
    }
}