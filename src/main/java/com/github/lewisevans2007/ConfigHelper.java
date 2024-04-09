/* Ping watch
 * A java tool to monitor ping time with coloured terminal output.
 * GitHub: https://www.github.com/lewisevans2007/PingWatch
 * Licence: GNU General Public License v3.0
 * By: Lewis Evans
 */

package com.github.lewisevans2007;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigHelper {
    public static String configPath = "config.conf";
    public static String fetchConfig(String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(configPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String configKey = parts[0].trim();
                    if (configKey.equals(key)) {
                        return parts[1].trim();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
