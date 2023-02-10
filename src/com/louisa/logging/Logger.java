package com.louisa.logging;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Instant;
import java.util.Date;

public class Logger {

    //TODO function that takes a message and writes it to terminal, file, or both
    //function lives here and is called in main

    public static void logNow(String message){
        System.out.println(message);
    }

    public static void logLater(String message){
        // Java program to create a text File using FileWriter
        String fileName = Date.from(Instant.now()).toString();
        File logStash = new File(fileName);

            try(FileWriter fw = new FileWriter(logStash)) {

                // attach a file to FileWriter


                    // read each character from string and write
                    // into FileWriter
                    for (int i = 0; i < message.length(); i++)
                        fw.write(message.charAt(i));

                    System.out.println("Logfile successfully written");

                    // close the file

                }
                catch (Exception e) {
                    e.getStackTrace();
                }

            }

        }

