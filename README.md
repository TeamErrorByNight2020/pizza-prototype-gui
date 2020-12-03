# pizza-prototype-gui

Created in under 30 days by Team EBN, as a group project for SWE 3313 at Kennesaw State University.

## Building the Project

Requires having Maven and JDK installed.

1. Download the repository.

2. Execute `mvn install`

3. The distributable JAR should now exist at `target/pizza-prototype-gui-1.0-SNAPSHOT-jar-with-dependencies.jar`.
   
   Note: Currently, the build step also generates a `pizza-prototype-gui-1.0-SNAPSHOT.jar`, which is not useable. Hopefully the final project should not emit this file.
   
## Running the Project

1. From command-line, execute `java -jar ./pizza-prototype-gui.jar`

   The final submission should include an executable script which can run the file by double-clicking.
