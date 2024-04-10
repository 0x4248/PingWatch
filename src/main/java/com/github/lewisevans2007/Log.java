/* Ping watch
 * A java tool to monitor ping time with coloured terminal output.
 * GitHub: https://www.github.com/lewisevans2007/PingWatch
 * Licence: GNU General Public License v3.0
 * By: Lewis Evans
 */


package com.github.lewisevans2007;

import java.io.*;
import java.text.*;
import java.util.*;

public class Log {
    public static String logPath = "log.txt";
    public static boolean logToFile = true;
    public static boolean logToConsole = true;

    public static int logLevel = 0;

    private static String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private static void log(String message, int level) {
        if (level < logLevel) {
            return;
        }
        String _logToFile = ConfigHelper.fetchConfig("SaveLogs");
        logToFile = Objects.equals(_logToFile, "true");
        System.out.println("LogToFile: " + logToFile);
        if (logToFile) {
            try {
                FileWriter fileWriter = new FileWriter(logPath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(message);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (logToConsole) {
            System.out.println(message);
        }
    }

    public static void Debug(String message) {
        if (logLevel <= 0) {
            String logMessage = "[" + getTime() + "] [DEBUG] " + message;
            log(logMessage, 0);
        }
    }

    public static void Info(String message) {
        if (logLevel <= 1) {
            String logMessage = "[" + getTime() + "] [INFO] " + message;
            log(logMessage, 1);
        }
    }

    public static void Warning(String message) {
        if (logLevel <= 2) {
            String logMessage = "[" + getTime() + "] [WARNING] " + message;
            log(logMessage, 2);
        }
    }

    public static void Error(String message) {
        if (logLevel <= 3) {
            String logMessage = "[" + getTime() + "] [ERROR] " + message;
            log(logMessage, 3);
        }
    }

    public static void Fatal(String message) {
        if (logLevel <= 4) {
            String logMessage = "[" + getTime() + "] [FATAL] " + message;
            log(logMessage, 4);
        }
    }
}
