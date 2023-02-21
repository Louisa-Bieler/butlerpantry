package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class ReadFile {

    //TODO Test would give file that doesnt exist and see if the corret logs and throws happen
    // give good file
    // give bad file

    public static File readFile(String defaultPantryFile) throws IOException {
        File myPantry = new File(defaultPantryFile);
        String logSuccess = "readFile Successful on " + new Date();
        Logger.logNow(logSuccess);
        return myPantry;

    }
}




