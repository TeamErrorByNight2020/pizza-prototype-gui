package io.github.teamerrorbynight2020.controllers;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;

import io.github.teamerrorbynight2020.model.Pizza;
import io.github.teamerrorbynight2020.App;

public class PizzaBuilderController {
  // The Pizza which is currently being modified.
  private Pizza pizza;

  private PizzaBuilderController(Pizza pizza) {
    this.pizza = pizza;
  }

  public static void show(Pizza pizza){
    PizzaBuilderController controller = new PizzaBuilderController(pizza);
    try {
          FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pizzabuilder.fxml"));
    fxmlLoader.setController(controller);
    Stage stage = new Stage();
    stage.setScene(new Scene(fxmlLoader.load(), 350, 400));
    stage.show();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  // GUI Controls
  @FXML
  private Label pizzaTypeLabel;
  @FXML
  private ChoiceBox<Pizza.CrustOption> crustChoice;
  @FXML
  private ChoiceBox<Pizza.CheeseOption> cheeseChoice;
  @FXML
  private ChoiceBox<Pizza.SauceOption> sauceChoice;
  @FXML
  private ChoiceBox<Pizza.Topping> toppingChoice1, toppingChoice2, toppingChoice3, toppingChoice4;
  @FXML
  private Button addToOrderButton;
  @FXML
  private Label priceLabel;

  @FXML
  private void initialize() {
    pizzaTypeLabel.setText(pizza.getName());
    priceLabel.setText(pizza.getPriceFormatted());

    // Initialize choiceboxes
    // TODO: don't repeat yourself
    crustChoice.getItems().setAll(Pizza.CrustOption.values());
    crustChoice.setValue(pizza.getCrust());
    crustChoice.setOnAction((event) -> {
      pizza.setCrust(crustChoice.getValue());
      update();
    });

    cheeseChoice.getItems().setAll(Pizza.CheeseOption.values());
    cheeseChoice.setValue(pizza.getCheese());
    cheeseChoice.setOnAction((event) -> {
      pizza.setCheese(cheeseChoice.getValue());
      update();
    });

    sauceChoice.getItems().setAll(Pizza.SauceOption.values());
    sauceChoice.setValue(sauceChoice.getItems().get(0));
    sauceChoice.setOnAction((event) -> {
      pizza.setSauce(sauceChoice.getValue());
      update();
    });

    toppingChoice1.getItems().setAll(Pizza.Topping.values());
    toppingChoice1.setValue(pizza.getNthTopping(1));
    toppingChoice1.setOnAction((event) -> {
      pizza.setNthTopping(1, toppingChoice1.getValue());
      update();
    });

    toppingChoice2.getItems().setAll(Pizza.Topping.values());
    toppingChoice2.setValue(pizza.getNthTopping(2));
    toppingChoice2.setOnAction((event) -> {
      pizza.setNthTopping(2, toppingChoice2.getValue());
      update();
    });

    toppingChoice3.getItems().setAll(Pizza.Topping.values());
    toppingChoice3.setValue(pizza.getNthTopping(3));
    toppingChoice3.setOnAction((event) -> {
      pizza.setNthTopping(3, toppingChoice3.getValue());
      update();
    });

    toppingChoice4.getItems().setAll(Pizza.Topping.values());
    toppingChoice4.setValue(pizza.getNthTopping(4));
    toppingChoice4.setOnAction((event) -> {
      pizza.setNthTopping(4, toppingChoice4.getValue());
      update();
    });
  }

  private void update() {
    pizzaTypeLabel.setText(pizza.getName());
    priceLabel.setText(pizza.getPriceFormatted());
  }


  @FXML
  private void handleSubmitButtonAction() {
    // TODO: add item to order, remove debug output
    System.out.println(pizza.getName());
    System.out.println(pizza.getDescription());
    System.out.println(pizza.getPriceFormatted());
    // Close window
    ((Stage) addToOrderButton.getScene().getWindow()).close();
  }
}