package main;

import com.butlerpantry.logging.Logger;
import com.butlerpantry.main.Pantry;
import com.butlerpantry.main.PantryLogic;
import com.butlerpantry.main.ReadFile;
import com.butlerpantry.main.UnitConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static com.butlerpantry.main.ReadFile.readFile;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PantryLogicTest {

    PantryLogicTest() throws IOException {
    }
    //filePaths to .csv files used for data persistence
    String defaultPantryFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/myPantry.csv";
    String shoppingTripFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/shoppingList.csv";
    String unitConversionsFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/unitConversions.csv";
    String recipeFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/recipe.csv";

    String badFilePath = "/Users/louisa.bieler/IdeaProjects/butlerpantry/badPantry.csv";

    //File objects created from csv files
    File testFile = readFile(defaultPantryFilePath);
    File shoppingTripFile = readFile(shoppingTripFilePath);
    File recipeFile = readFile(recipeFilePath);
    File badDataPantryFile = readFile(badFilePath);


    @Test
    void producePantryFromFileHappyPath() throws Exception {
        UnitConversion.addUnitConversionMapping(unitConversionsFilePath);
        Pantry myPantry = PantryLogic.producePantryFromFile(testFile);
        Assertions.assertEquals("milk,ml,2000.00\nraspberry jam,gram,300.00\npeanut butter,gram,500.00\nbread,piece,10.00\n", myPantry.toString());
    }

    @Test
    void producePantryFromFileBadFile() throws Exception {
        Exception badDataException = assertThrows(Exception.class, () -> {
            UnitConversion.addUnitConversionMapping(unitConversionsFilePath);
            Pantry badPantry = PantryLogic.producePantryFromFile(badDataPantryFile);
        });
        Logger.logNow(badDataException.getMessage());
    }



    @Test
    void saveShoppingListAsAFile() {
    }

    @Test
    void addShopping() {
    }
}