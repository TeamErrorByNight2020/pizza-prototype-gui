# pizza-prototype-gui

<img width="500" alt="Screenshot of main GUI" src="https://user-images.githubusercontent.com/4561733/100676416-dafa0100-3336-11eb-9d5d-50f82867830e.png">

A minimal pizza ordering system written in JavaFX. Created as a group project for SWE 3313.

## Running the Program

1. Download the latest JAR file from the [Releases](https://github.com/TeamErrorByNight2020/pizza-prototype-gui/releases) page.

2. From command-line, execute `java -jar ./pizza-prototype-gui.jar`

## Development

Requires having Maven and the JDK installed.

1. Download or clone this repository to your computer.

2. Execute `mvn javafx:run` to run the code and test changes.

3. When ready for distribution, execute `mvn install`.

4. A distributable JAR should now exist at `target/pizza-prototype-gui-XXX-jar-with-dependencies.jar`
   
   Note: Currently, the build step also generates a `pizza-prototype-gui-XXX.jar`, which is not useable. Maven is hard, and I don't know why it does this. This one should be ignored.
