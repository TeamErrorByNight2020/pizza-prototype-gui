package io.github.teamerrorbynight2020.model;
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
    PEPSI("Pepsi"), DIET_PEPSI("Diet Pepsi"), ORANGE_CRUSH("Orange CRUSH"), DIET_CRUSH("Diet CRUSH"),
    MUG_ROOT_BEER("Mug Root Beer"), DIET_ROOT_BEER("Diet Root Beer");

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
    return beverage.toString() + " - " + size.toString();
  }

  @Override
  public int getPrice() {
    return this.size.getPrice();
  }
}
