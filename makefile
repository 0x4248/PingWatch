# Ping watch
# A java tool to monitor ping time with coloured terminal output.
# GitHub: https://www.github.com/lewisevans2007/PingWatch
# Licence: GNU General Public License v3.0
# By: Lewis Evans

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
