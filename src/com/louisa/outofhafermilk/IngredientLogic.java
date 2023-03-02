package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public static class IngredientLogic {




    public static Ingredient returnIngredient(String g) {

        try {
            String line = g;
            String[] lineParts = line.split(",");
            String name = lineParts[0];
            String unit = lineParts[1];
            Double amount = Double.parseDouble(lineParts[2]);
        } catch (Exception e) {
            Logger.logNow(e.getMessage());
            throw e;
        }

            //if the unit is not in this list, then just go put it in
            //unless it has an empty character, or unacceptable type of string like lots of punctuation or digits or such
            //if it is in this list(maintained forced lower case list of possible iterations of weight or volume)
            //if a decaliter comes in we want to multply by the factor instead of dividing hence the factor should be a Double
            Ingredient newIngredient  = new Ingredient(name, unit, amount);
            return newIngredient;

        }

    }


    public HashMap<String, Double> getUnitAmount() {
        return unitAmount;
    }
    public void setAmountFromRecipe(Ingredient recipeIngredient){
        recipeIngredient.getUnitAmount().forEach(
                (unitKey, unitValue) -> {
                    if (this.unitAmount.keySet().contains(unitKey)) {
                        this.getUnitAmount().merge(
                                unitKey, unitValue, (value1, value2)
                                        -> {
                                    if (value1 - value2 > 0) {
                                        return value1 - value2;
                                    } else {
                                        return value1;
                                    }
                                }
                        );
                    }
                }
        );
    }

    public Ingredient createShoppingListIngredient(Ingredient recipeIngredient){
        Ingredient temp = new Ingredient(recipeIngredient);
        recipeIngredient.getUnitAmount().forEach(
                (unitKey, unitValue) -> {
                    if (this.unitAmount.keySet().contains(unitKey)) {
                        Double currentAmount = this.unitAmount.get(unitKey);
                        if ((recipeIngredient.getUnitAmount().get(unitKey)-currentAmount) < 0){
                            temp.setAmountFromScratch(unitKey, recipeIngredient.getAmount(unitKey)-currentAmount);
                        }
                    }
                }
        );
        return temp;
    }
}
