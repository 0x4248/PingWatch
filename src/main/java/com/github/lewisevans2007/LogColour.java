/* Ping watch
 * A java tool to monitor ping time with coloured terminal output.
 * GitHub: https://www.github.com/lewisevans2007/PingWatch
 * Licence: GNU General Public License v3.0
 * By: Lewis Evans
 */

package com.github.lewisevans2007;

public class LogColour {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static String GenerateColourCode(int r, int g, int b) {
        return "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
    }
}