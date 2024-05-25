# Ping Watch

A java tool to monitor ping time with coloured terminal output.

## Usage

```bash
java -jar PingWatch.jar -c config.conf
```

## Configuration

```properties
# PingWatch Configuration

Domain: 1.1.1.1
Port: 80
Timeout: 1000

# Simple mode

# Defines on weather to show logs or just the result
BasicMode: false

# Logs
SaveLogs: true
LogPath: logs.txt

# PingLogs
ShowPingLogs: true
SavePingLogs: true
PingLogPath: pings.txt
```

## Licence

This project is licenced under the GNU General Public License v3.0. For more information, see the [LICENSE](LICENSE) file.
