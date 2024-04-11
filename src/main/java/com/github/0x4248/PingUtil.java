/* Ping watch
 * A java tool to monitor ping time with coloured terminal output.
 * GitHub: https://www.github.com/0x4248/PingWatch
 * Licence: GNU General Public License v3.0
 * By: 0x4248
 */

package com.github.0x4248;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class PingUtil {
    public static long ping(String host, int port) {
        try {
            long start = System.currentTimeMillis();
            Socket socket = new Socket(host, port);
            long end = System.currentTimeMillis();
            return end - start;
        } catch (IOException e) {
            return -1;
        }
    }

    public static boolean isConnected() {
        ArrayList<String> hosts = new ArrayList<String>();
        hosts.add("google.com");
        hosts.add("cloudflare.com");
        hosts.add("github.com");
        hosts.add("microsoft.com");
        hosts.add("apple.com");
        hosts.add("amazon.com");

        for (String host : hosts) {
            if (ping(host, 80) != -1) {
                return true;
            }
        }
        return false;
    }
}
