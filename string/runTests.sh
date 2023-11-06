#!/usr/bin/env bash

javac -d target -cp ../jars/junit-platform-console-standalone-1.9.3.jar FirstUnitTest.java
java -jar ../jars/junit-platform-console-standalone-1.9.3.jar --classpath target --select-class  FirstUnitTest