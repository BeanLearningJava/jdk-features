#!/usr/bin/env bash

javac -d target --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX.java

# javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml HelloFX.java

java --class-path target --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX