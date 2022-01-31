package edu.illinoisstate.it296.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handles all logging
 */
public class Logger {

    public boolean info(String message) {
        try {

            /*
            Non-complaint example: return value of createNewFile() is ignored
             */
//            File commandFile = new File("commands.txt");
//
//            if (!commandFile.exists()) {
//                commandFile.createNewFile();
//            }

            /*
            Compliant example
             */
            File commandFile = new File("commands.txt");

            if (!commandFile.exists()) {
                if (!commandFile.createNewFile()) {
                    System.out.println("Failed to create the commands.txt file.");
                    return true;
                }
            }

            FileWriter writer = new FileWriter(commandFile, true);
            PrintWriter printer = new PrintWriter(writer);

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();

            printer.println("[" + formatter.format(date) + "] " + message);
            printer.flush();
            printer.close();
            return true; // success, so return true
        } catch (IOException e) {
            e.printStackTrace();
            return false; // fail, so return false
        }
    }

}
