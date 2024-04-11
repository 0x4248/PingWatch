# Ping watch
# A java tool to monitor ping time with coloured terminal output.
# GitHub: https://www.github.com/0x4248/PingWatch
# Licence: GNU General Public License v3.0
# By: 0x4248

# Variables
MVM = mvn

all: build

build:
	$(MVM) compile
	$(MVM) package

build_class:
	$(MVM) compile

clean:
	$(MVM) clean
