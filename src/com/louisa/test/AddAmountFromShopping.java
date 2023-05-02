package com.louisa.test;
import com.louisa.butlerpantry.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AddAmountFromShopping {

    @Test
    public void testAddAmountFromShopping() {
        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(1000));
        testIngredient.addAmountFromShopping(BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(1500).setScale(2), testIngredient.getAmount());
    }

    @Test
    public void testAddNegativeAmount() {
        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(50));
        testIngredient.addAmountFromShopping(BigDecimal.valueOf(-0.2));
        assertEquals(BigDecimal.valueOf(49.8).setScale(2), testIngredient.getAmount());
    }

    @Test
    public void testAddAmountFromShoppingWhenAmountIsNegative() {
        Ingredient testIngredient = new Ingredient("Flour", "g", BigDecimal.valueOf(1000));
        IllegalArgumentException negativeNumber = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testIngredient.addAmountFromShopping(BigDecimal.valueOf(-500));
        });
    }
}