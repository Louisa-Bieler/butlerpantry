package com.louisa.test;
import com.louisa.butlerpantry.Ingredient;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddAmountFromShopping {


    @Test
    public void testAddAmountFromShopping() {
        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(1000.0));
        testIngredient.addAmountFromShopping(BigDecimal.valueOf(500.0));
        assertEquals(BigDecimal.valueOf(1500), testIngredient.getAmount());
    }

    @Test
    public void testAddNegativeAmount() {
        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(50));
        testIngredient.addAmountFromShopping(BigDecimal.valueOf(-0.2));
        assertEquals(49.8, testIngredient.getAmount());
    }
}