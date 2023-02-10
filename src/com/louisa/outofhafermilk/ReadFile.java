package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class ReadFile {



    public static File readFile(String defaultPantryFile) {
        try {
            File myPantry = new File(defaultPantryFile);
            String logSuccess = "readFile Successful on " + new Date();
            Logger.logNow(logSuccess);
            return myPantry;
        } catch (Exception f) {
            String logFail = "readFile Failed on " + new Date();
            Logger.logNow(logFail);
            Logger.logLater(logFail);
        }
        return null;

    }
}




