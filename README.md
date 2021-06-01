# SE-project-GymApp
README

## Requirement and Dependencies

JDK-13

## Installation

First go to the directory where there are 2 subdirectories: “com” and “META-INF”.

Run in PowerShell: 

```
javac .\com\londonfitness\App.java
```

The source code will be compiled.

Then run:

```
jar -cvfm GymApp.jar .\META-INF\MANIFEST.MF .\com
```

There will be a "GymApp.jar" file in the directory, which can click-and-run.

There is a pre-built "GymApp.jar" in "example" directory.

## Use

For the first use, the "GymApp.jar" will generate "./cache" and "./resources" directories, as well as a "./resources.xml" file. 

you need to set up basic running environment by editing this "data.xml". There is an example in the "../example/resources/data.xml", youjust need to copy and paste it into "./resources".

Open "GymApp.jar" again and you will have GUI.

