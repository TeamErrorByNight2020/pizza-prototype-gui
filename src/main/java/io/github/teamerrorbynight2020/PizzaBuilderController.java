package io.github.teamerrorbynight2020;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PizzaBuilderController {
  // The Pizza.
  private Pizza pizza;

  public PizzaBuilderController(Pizza pizza) {
    this.pizza = pizza;
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
    priceLabel.setText(getPizzaPrice());
    // Initialize choiceboxes
    // TODO: don't repeat yourself
    crustChoice.getItems().setAll(Pizza.CrustOption.values());
    crustChoice.setValue(crustChoice.getItems().get(0));
    crustChoice.setOnAction((event) -> {
      pizza.setCrust(crustChoice.getValue());
      update();
    });

    cheeseChoice.getItems().setAll(Pizza.CheeseOption.values());
    cheeseChoice.setValue(cheeseChoice.getItems().get(0));
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
    toppingChoice1.setValue(toppingChoice1.getItems().get(0));
    toppingChoice1.setOnAction((event) -> {
      pizza.setNthTopping(1, toppingChoice1.getValue());
      update();
    });

    toppingChoice2.getItems().setAll(Pizza.Topping.values());
    toppingChoice2.setValue(toppingChoice1.getItems().get(0));
    toppingChoice2.setOnAction((event) -> {
      pizza.setNthTopping(2, toppingChoice2.getValue());
      update();
    });

    toppingChoice3.getItems().setAll(Pizza.Topping.values());
    toppingChoice3.setValue(toppingChoice1.getItems().get(0));
    toppingChoice3.setOnAction((event) -> {
      pizza.setNthTopping(3, toppingChoice3.getValue());
      update();
    });

    toppingChoice4.getItems().setAll(Pizza.Topping.values());
    toppingChoice4.setValue(toppingChoice1.getItems().get(0));
    toppingChoice4.setOnAction((event) -> {
      pizza.setNthTopping(4, toppingChoice4.getValue());
      update();
    });
  }

  private void update() {
    pizzaTypeLabel.setText(getPizzaType());
    priceLabel.setText(getPizzaPrice());
    // TODO: Remove debug output
    System.out.println(pizza.getName());
    System.out.println(pizza.getDescription());
    System.out.println(App.formatPrice(pizza.getPrice()));
  }

  private String getPizzaType() {
    return pizza.getName();
  }

  private String getPizzaPrice() {
    return App.formatPrice(pizza.getPrice());
  }

  @FXML
  private void handleSubmitButtonAction() {
    // TODO: add item to order
    System.out.println(pizza.getName());
    System.out.println(pizza.getDescription());
    System.out.println(App.formatPrice(pizza.getPrice()));
    ((javafx.stage.Stage) addToOrderButton.getScene().getWindow()).close();
  }
}