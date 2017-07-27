#!/bin/bash          

cd src/
javac **/*.java
javac *.java
java Main
sudo rm -r *.class
cd app/
sudo rm -r *.class
cd ../util
sudo rm -r *.class
cd ../gui
sudo rm -r *.class
cd ../../


