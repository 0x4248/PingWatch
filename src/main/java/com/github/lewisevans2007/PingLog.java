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


public class PingLog {
    public static String logPath = "log.txt";
    public static boolean logToFile = true;
    public static boolean logToConsole = true;
    private static void log(String message) {
        String _logToFile = ConfigHelper.fetchConfig("SavePingLogs");
        logToFile = Objects.equals(_logToFile, "true");
        String _logToConsole = ConfigHelper.fetchConfig("ShowPingLogs");
        logToConsole = Objects.equals(_logToConsole, "true");
        if (logToFile) {
            try {
                if (logToFile != false) {
                    String logPath = ConfigHelper.fetchConfig("PingLogPath");
                    FileWriter fileWriter = new FileWriter(logPath, true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.println(message);
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (logToConsole) {
            System.out.println(message);
        }
    }
    public static void pingLog(String host, int port, long time) {
        String show_ping = ConfigHelper.fetchConfig("ShowPingLogs");
        if (Objects.equals(show_ping, "false")) {
            return;
        }

        int r = 0;
        int g = 0;
        int b = 0;
        if (time < 10) {
            g = 255;
        } if (time < 25) {
            r = 64;
            g = 255;
        } else if (time < 50) {
            r = 128;
            g = 255;
        } else if (time < 75) {
            r = 192;
            g = 255;
        } else if (time < 100) {
            r = 255;
            g = 255;
        } else if (time < 200) {
            r = 255;
            g = 1228;
        } else {
            r = 255;
        }
        String DisplayMode = ConfigHelper.fetchConfig("BasicMode");

        if (Objects.equals(DisplayMode, "true")) {
            String logMessage = LogColour.GenerateColourCode(r, g, b) + time + "ms" + LogColour.RESET;
            log(logMessage);
            return;
        } else {
            String logMessage = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] [PING --> " + host + ":" + port + "] " + LogColour.GenerateColourCode(r, g, b) + time + "ms" + LogColour.RESET;
            log(logMessage);
        }
    }

    public static void pingfaillog(String host, int port) {
        String logMessage = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] [PING -" + LogColour.RED + "X" + LogColour.RESET + "- " + host + ":" + port + "] " + LogColour.RED + "FAILED" + LogColour.RESET;
        log(logMessage);
    }

}
