package com.louisa.outofhafermilk;

import java.lang.reflect.Method;
import java.util.*;

public class UnitConversion {


    private static HashMap<Set<String>, String> unitConversions  = new HashMap<>();
    private static HashMap<String, Double> unitValueConversions = new HashMap<>();

/*Initializing fixed-length arrays first and then using Arrays.asList to add them to HashSets, because I will only infrequently be adding to these
sets, but every single time I open the program, everything has to be initialized, and the time it takes to use Arrays.asList to initialize a HashSet
is supposed to be the fastest way to do it: and I want HashSets instead of Arrays in the end bc I can do lookups instead of iterations every
time I add a new ingredient and want to convert its amount.
 */
    //STRING ARRAYS




    public static void loadConversionHashMaps(){
        String[] kilograms = new String[]{"kg", "kilograms", "kgrams", "kilo", "k"};
        String[] grams = new String[]{"grams", "g", "gm"};
        String[] milligrams = new String[]{"mg", "miligrams", "milligrams", "mgs"};
        String[] liters = new String[]{"liters", "ltrs", "l", "ltr"};
        String[] milliliters = new String[]{"ml", "milliliters", "mltrs"};
        String[] teaspoon = new String[]{"tsp", "tp", "teaspoon"};
        String[] tablespoon = new String[]{"tablespoon", "tblsp"};

        //HASHSETS
        Set<String> kg = new HashSet<>(Arrays.asList(kilograms));
        Set<String> g = new HashSet<>(Arrays.asList(grams));
        Set<String> mg = new HashSet<>(Arrays.asList(milligrams));
        Set<String> l = new HashSet<>(Arrays.asList(liters));
        Set<String> ml = new HashSet<>(Arrays.asList(milliliters));
        Set<String> t = new HashSet<>(Arrays.asList(teaspoon));
        Set<String> tB = new HashSet<>(Arrays.asList(tablespoon));

        unitConversions.put(kg, "kg");
        unitConversions.put(g, "g");
        unitConversions.put(mg, "mg");
        unitConversions.put(l, "l");
        unitConversions.put(ml, "ml");
        unitConversions.put(t, "t");
        unitConversions.put(tB, "tB");

        unitValueConversions.put("kg", 1000.0);
        unitValueConversions.put("g", 1.0);
        unitValueConversions.put("mg", 0.001);
        unitValueConversions.put("l", 1000.0);
        unitValueConversions.put("ml", 1.0);
        unitValueConversions.put("t", 4.292);
        unitValueConversions.put("tB", 14.7868);
    }

    public static String convertUnitName(String unit){
        String returnValue = null;
        if (unit.equals("T")){
            returnValue = "tB";
        } else {
        for (Map.Entry<Set<String>, String> entry : unitConversions.entrySet()) {
            Set<String> keySet = entry.getKey();
            String value = entry.getValue();
            if (keySet.contains(unit.toLowerCase())) {
                returnValue = value;
            }
        }}
        if (returnValue != null){
            return returnValue;
        } else {
            return unit;
        }

    }

    public static Double convertUnitAmount(String unit, Double value){
        if (unitValueConversions.get(unit) != null){
            return unitValueConversions.get(unit) * value;
        } else {
            return value;
        }
    }

    public static String nonMetricUnits(String unit){
        if (unit.equals("tB") | unit.equals("t")){
            return "g";
        } else {
            return unit;
        }
    }







}
