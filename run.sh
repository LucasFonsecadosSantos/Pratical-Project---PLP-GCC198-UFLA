#!/bin/bash          

cd src/
javac -d ../build *.java
javac -d ../build **/*.java
cd ../build
java Main


