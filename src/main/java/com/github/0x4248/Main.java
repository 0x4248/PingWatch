/** Ping watch
 * A java tool to monitor ping time with coloured terminal output.
 * GitHub: https://www.github.com/0x4248/PingWatch
 * By: 0x4248
*/

package com.github.0x4248;

public class Main {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Log.Info("Starting Ping Watch");

        String configPath = "config.conf";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-c")) {
                if (i + 1 < args.length) {
                    configPath = args[i + 1];
                }
            }
        }
        ConfigHelper.configPath = configPath;
        String ConfigHost = ConfigHelper.fetchConfig("Domain");
        String host = ConfigHost;
        String ConfigPort = ConfigHelper.fetchConfig("Port");
        int port = Integer.parseInt(ConfigPort);
        String clearScreen = ConfigHelper.fetchConfig("ClearScreenAfterPing");
        while (true) {
            long ping = PingUtil.ping(host, port);
            if (ping == -1) {
                if (clearScreen.equals("true")) {
                    clearScreen();
                }
                Log.Info("Ping failed");
                PingLog.pingfaillog(host, port);
            } else {
                if (clearScreen.equals("true")) {
                    clearScreen();
                }
                PingLog.pingLog(host, port, ping);
            }
            try {
                String _pingInterval = ConfigHelper.fetchConfig("Timeout");
                int pingInterval = Integer.parseInt(_pingInterval);
                Thread.sleep(pingInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
