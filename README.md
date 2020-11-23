# pizza-prototype-gui
A project for SWE 3313

## Building the Project

Requires having Maven and JDK installed.

1. Download the repository.

2. Execute `mvn install`

3. The distributable JAR should now exist at `target/pizza-prototype-gui-1.0-SNAPSHOT-jar-with-dependencies.jar`.
   
   Note: Currently, the build step also generates a `pizza-prototype-gui-1.0-SNAPSHOT.jar`, which is not useable. Hopefully the final project should not emit this file.

4. Execute using `java -jar target.jar`.
