# pizza-prototype-gui

<img width="500" alt="Screenshot of main GUI" src="https://user-images.githubusercontent.com/4561733/100676416-dafa0100-3336-11eb-9d5d-50f82867830e.png">

A minimal pizza ordering system written in JavaFX. Created as a group project for SWE 3313.

## Building the Project

Requires having Maven and JDK installed.

1. Download the repository.

2. Execute `mvn install`

3. The distributable JAR should now exist at `target/pizza-prototype-gui-XXX-jar-with-dependencies.jar`.
   
   Note: Currently, the build step also generates a `pizza-prototype-gui-XXX.jar`, which is not useable. This bundle should be ignored.
   
## Running the Executable

1. From command-line, execute `java -jar ./pizza-prototype-gui.jar`

## Building the Project

Requires having Maven and JDK installed.

1. Download the repository.

2. Execute `mvn install`

3. The distributable JAR should now exist at `target/pizza-prototype-gui-1.0-SNAPSHOT-jar-with-dependencies.jar`.
   
   Note: Currently, the build step also generates a `pizza-prototype-gui-1.0-SNAPSHOT.jar`, which is not useable. Hopefully the final project should not emit this file.
   
## Running the Project

1. From command-line, execute `java -jar ./pizza-prototype-gui.jar`

   The final submission should include an executable script which can run the file by double-clicking.
