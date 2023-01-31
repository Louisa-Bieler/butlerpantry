package com.louisa.outofhafermilk;

import com.louisa.logging.Logger;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String message = "I'm Logging!";
        Logger.logNow(message);
        Logger.logLater(message);
    }
}