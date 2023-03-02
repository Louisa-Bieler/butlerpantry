package com.louisa.outofhafermilk;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UnitConversion {


    private HashMap<Set<String>, Double> unitConversions = new HashMap<>();

/*Initializing fixed-length arrays first and then using Arrays.asList to add them to HashSets, because I will only infrequently be adding to these
sets, but every single time I open the program, everything has to be initialized, and the time it takes to use Arrays.asList to initialize a HashSet
is supposedn to be the fastest way to do it: and I want HashSets instead of Arrays in the end bc I can do lookups instead of iterations every
time I add a new ingredient and want to convert its
 */
    //STRING ARRAYS
    String[] kilograms = new String[]{"kg", "kilograms", "kgrams", "kilo", "k"};
    String[] grams = new String[]{"grams", "g", "gm"};
    String[] milligrams = new String[]{"mg", "miligrams", "milligrams", "mgs"};
    String[] liters = new String[]{"liters", "ltrs", "l", "ltr"};
    String[] milliliters = new String[]{"ml", "milliliters", "mltrs"};
    String[] teaspoon = new String[]{"tsp", "t", "tp", "teaspoon"};
    String[] tablespoon = new String[]{"T", "tablespoon", "tblsp"};

    //HASHSETS
    Set<String> kg = new HashSet<>(Arrays.asList(kilograms));
    Set<String> g = new HashSet<>(Arrays.asList(grams));
    Set<String> mg = new HashSet<>(Arrays.asList(milligrams));
    Set<String> l = new HashSet<>(Arrays.asList(liters));
    Set<String> ml = new HashSet<>(Arrays.asList(milliliters));
    Set<String> t = new HashSet<>(Arrays.asList(teaspoon));
    Set<String> tB = new HashSet<>(Arrays.asList(tablespoon));


    public HashMap<Set<String>, Double> getUnitConversions() {
        return unitConversions;
    }

    public void setUnitConversions(HashMap<Set<String>, Double> unitConversions) {
        this.unitConversions = unitConversions;
    }

    public String[] getKilograms() {
        return kilograms;
    }

    public void setKilograms(String[] kilograms) {
        this.kilograms = kilograms;
    }

    public String[] getGrams() {
        return grams;
    }

    public void setGrams(String[] grams) {
        this.grams = grams;
    }

    public String[] getMilligrams() {
        return milligrams;
    }

    public void setMilligrams(String[] milligrams) {
        this.milligrams = milligrams;
    }

    public String[] getLiters() {
        return liters;
    }

    public void setLiters(String[] liters) {
        this.liters = liters;
    }

    public String[] getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(String[] milliliters) {
        this.milliliters = milliliters;
    }

    public String[] getTeaspoon() {
        return teaspoon;
    }

    public void setTeaspoon(String[] teaspoon) {
        this.teaspoon = teaspoon;
    }

    public String[] getTablespoon() {
        return tablespoon;
    }

    public void setTablespoon(String[] tablespoon) {
        this.tablespoon = tablespoon;
    }

    public Set<String> getKg() {
        return kg;
    }

    public void setKg(Set<String> kg) {
        this.kg = kg;
    }

    public Set<String> getG() {
        return g;
    }

    public void setG(Set<String> g) {
        this.g = g;
    }

    public Set<String> getMg() {
        return mg;
    }

    public void setMg(Set<String> mg) {
        this.mg = mg;
    }

    public Set<String> getL() {
        return l;
    }

    public void setL(Set<String> l) {
        this.l = l;
    }

    public Set<String> getMl() {
        return ml;
    }

    public void setMl(Set<String> ml) {
        this.ml = ml;
    }

    public Set<String> getT() {
        return t;
    }

    public void setT(Set<String> t) {
        this.t = t;
    }

    public Set<String> gettB() {
        return tB;
    }

    public void settB(Set<String> tB) {
        this.tB = tB;
    }
    public void populateHashMap(){
        this.unitConversions.put()
    }

}
