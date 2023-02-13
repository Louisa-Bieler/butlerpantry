package com.louisa.outofhafermilk;

import java.io.File;
import java.io.FileWriter;

public class WriteFile {

    String filename = "updatedCsv.csv";
    File updatedCsv = new File(filename);
        try (
    FileWriter fw = new FileWriter(filename)){
        for (int i = 0; i < testPantry.getInventory().size(); i++)
            fw.write(message.charAt(i));
}
