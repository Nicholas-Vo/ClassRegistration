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

    public boolean logCommand(String message) {
        try {
            File commandFile = new File("commands.txt");

            if (!commandFile.exists()) {
                commandFile.createNewFile();
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
