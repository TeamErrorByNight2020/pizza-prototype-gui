package io.github.teamerrorbynight2020.controllers;

import io.github.teamerrorbynight2020.model.Beverage;
import io.github.teamerrorbynight2020.model.GenericOrderItem;
import io.github.teamerrorbynight2020.model.OrderItem;
import io.github.teamerrorbynight2020.model.Pizza;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.*;

public class OrderMenuController {

  @FXML
  private ChoiceBox<Beverage.Size> pepsiSizeChoice, dietPepsiSizeChoice, orangeCrushSizeChoice, dietCrushSizeChoice,
  mugRootBeerSizeChoice, dietRootBeerSizeChoice;

  @FXML
  private ListView<OrderItem> orderListView;

  @FXML
  private Label orderSubtotalLabel;

  @FXML
  private Button deleteItemButton;

  @FXML
  private Button completeOrderButton;

  public void addOrderItem(OrderItem o) {
    orderListView.getItems().add(o);
  }

  private void updateSubtotal() {
    int subtotal = 0;
    for (OrderItem o : orderListView.getItems()) {
      subtotal += o.getPrice();
    }
    orderSubtotalLabel.setText(OrderItem.formatPriceString(subtotal));
  }

  @FXML
  void handleDeleteItem(ActionEvent event) {
    int selectedIndex = orderListView.getSelectionModel().getSelectedIndex();
    orderListView.getItems().remove(selectedIndex);
    updateSubtotal();
  }

  @FXML
  private void initialize() {
    // Initialize drink selector
    for (ChoiceBox<Beverage.Size> sizeChoice : Arrays.asList(pepsiSizeChoice, dietPepsiSizeChoice,
    orangeCrushSizeChoice, dietCrushSizeChoice, mugRootBeerSizeChoice, dietRootBeerSizeChoice)) {
      sizeChoice.getItems().setAll(Beverage.Size.values());
      sizeChoice.setValue(sizeChoice.getItems().get(0));
    }
    // ChangeListener: when an order is selected, enable the delete button
    orderListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        deleteItemButton.setDisable(newValue.intValue() == -1);
      }
    });
    // Listener: When an item is added or removed, update the subtotal.
    orderListView.getItems().addListener(new ListChangeListener<OrderItem>() {

      @Override
      public void onChanged(Change<? extends OrderItem> c) {
        updateSubtotal();
      }
    });

    updateSubtotal();
  }

  @FXML
  void handleAddSmallPizza(ActionEvent event) {
    PizzaBuilderController.show(Pizza.Size.SMALL, this);
  }

  @FXML
  void handleAddMediumPizza(ActionEvent event) {
    PizzaBuilderController.show(Pizza.Size.MEDIUM, this);
  }

  @FXML
  void handleAddLargePizza(ActionEvent event) {
    PizzaBuilderController.show(Pizza.Size.LARGE, this);
  }

  @FXML
  void handleAddXLargePizza(ActionEvent event) {
    PizzaBuilderController.show(Pizza.Size.XLARGE, this);
  }

  @FXML
  void handleAddChocoCookie(ActionEvent event) {
    addOrderItem(new GenericOrderItem("Chocolate Chip Cookie", 400));
  }

  @FXML
  void handleAddBreadsticks(ActionEvent event) {
    addOrderItem(new GenericOrderItem("Breadsticks", 400));
  }

  @FXML
  void handleAddBreadstickBites(ActionEvent event) {
    addOrderItem(new GenericOrderItem("Breadstick Bites", 200));
  }


  @FXML
  void handleAddPepsi(ActionEvent event) {
    Beverage.Size size = pepsiSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.PEPSI));
  }

  @FXML
  void handleAddDietPepsi(ActionEvent event) {
    Beverage.Size size = dietPepsiSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.DIET_PEPSI));
  }

  @FXML
  void handleAddOrangeCrush(ActionEvent event) {
    Beverage.Size size = orangeCrushSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.ORANGE_CRUSH));
  }

  @FXML
  void handleAddDietCrush(ActionEvent event) {
    Beverage.Size size = dietCrushSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.DIET_CRUSH));
  }

  @FXML
  void handleAddMugRootBeer(ActionEvent event) {
    Beverage.Size size = mugRootBeerSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.MUG_ROOT_BEER));
  }

  @FXML
  void handleAddDietRootBeer(ActionEvent event) {
    Beverage.Size size = dietRootBeerSizeChoice.getValue();
    addOrderItem(new Beverage(size, Beverage.BeverageOption.DIET_ROOT_BEER));
  }

  @FXML
  void handleCompleteOrder(ActionEvent event) {

  }

}
