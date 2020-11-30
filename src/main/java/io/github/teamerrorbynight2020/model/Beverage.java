package io.github.teamerrorbynight2020.model;

import java.util.*;

public class Beverage extends OrderItem {

  public static enum Size {
    // Declare drink sizes and pricing scheme here.
    SMALL("Small", 100), MEDIUM("Medium", 100), LARGE("Large", 100);

    private final String name;
    private final int price;

    private Size(String name, int price) {
      this.name = name;
      this.price = price;
    }
    public int getPrice() {
      return this.price;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  public static enum BeverageOption {
    // TODO: Declare remaining drink sizes and pricing scheme.
    PEPSI("Pepsi"), DIET_PEPSI("Diet Pepsi");

    private final String name;

    private BeverageOption(String name) {
      this.name = name;
    }

    /**
     * @returns Product name for a pizza of this size i.e. "Small Pizza (11-inch)"
     */
    @Override
    public String toString() {
      return this.name;
    }
  }

  private Size size;
  private BeverageOption beverage;

  public Beverage(Size size, BeverageOption beverage) {
    this.size = size;
    this.beverage = beverage;
  }

  @Override
  public String getName() {
    return beverage.toString();
  }

  @Override
  public int getPrice() {
    return size.getPrice();
  }

  @Override
  public List<String> getDescriptionItems() {
    return Arrays.asList(size.toString());
  }
}