# Ping watch makefile
# Makfile makes jar

# Variables
MVM = mvn

all: build post

build:
	$(MVM) clean install