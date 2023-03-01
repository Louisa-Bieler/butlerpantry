package com.louisa.butlerspantry;

import com.louisa.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ReadFile {

    //TODO Test would give file that doesnt exist and see if the corret logs and throws happen
    // give good file
    // give bad file

    public static File readFile(String defaultInputFile) throws IOException {
        File fileObject = new File(defaultInputFile);
        String logSuccess = "readFile Successful on " + new Date();
        Logger.logLater(logSuccess);
        return fileObject;

    }
}




