package io.github.teamerrorbynight2020;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Welcome!");
        alert.setHeaderText("Welcome, Mom & Pop!");
        alert.setContentText("This program is an interactive prototype of the ordering system for Mom & Pop's Pizzeria.");
        alert.showAndWait();
        //
        scene = new Scene(loadFXML("ordermenu"));
        stage.setScene(scene);
        stage.setTitle("Mom & Pop's Pizzeria - Ordering Screen [PROTOTYPE]");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}