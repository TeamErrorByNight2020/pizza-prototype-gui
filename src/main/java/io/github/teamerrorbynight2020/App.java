package io.github.teamerrorbynight2020;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static String formatPrice(int cents) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cents / 100.0);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        showPizzaBuilder(Pizza.Size.SMALL);
        showPizzaBuilder(Pizza.Size.MEDIUM);
        showPizzaBuilder(Pizza.Size.LARGE);
        showPizzaBuilder(Pizza.Size.XLARGE);
    }

    public void showPizzaBuilder(Pizza.Size size) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pizzabuilder.fxml"));
        fxmlLoader.setController(new PizzaBuilderController(size));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        Stage stage = new Stage();
        stage.setScene(scene);
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