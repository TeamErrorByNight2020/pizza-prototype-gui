package io.github.teamerrorbynight2020.model;

import java.util.*;

public class Pizza extends OrderItem {
  // The maximum number of toppings which can go on a single pizza.
  public static final int MAX_TOPPINGS = 4;

  /** Sizes of pizza. */
  public static enum Size {
    // Declare pizza sizes and pricing scheme here
    SMALL("Small Pizza (11-inch)", 400, 50), MEDIUM("Medium Pizza (13-inch)", 600, 75),
    LARGE("Large Pizza (15-inch)", 800, 100), XLARGE("X-Large Pizza (17-inch)", 1000, 125);

    private final String name;
    /** The price (in cents) of this size pizza with 1 topping */
    private final int priceBase;
    /** The price (in cents) of one extra topping on this size pizza. */
    private final int perTopping; // internally, prices are stored as an integer of cents

    private Size(String name, int priceBase, int perTopping) {
      this.name = name;
      this.priceBase = priceBase;
      this.perTopping = perTopping;
    }
    public int calculatePrice(int toppingCount) {
      int price = this.priceBase;
      if (toppingCount > 1) {
        price += (toppingCount - 1) * perTopping;
      }
      return price;
    }

    public int getBasePrice() {
      return this.priceBase;
    }
    public int getPricePerTopping() {
      return this.perTopping;
    }
    /**
     * @returns Product name for a pizza of this size i.e. "Small Pizza (11-inch)"
     */
    @Override
    public String toString() {
      return this.name;
    }
  }

  /**
   * Toppings which can go on a Pizza. The default value for this property is the
   * first item in this Enum.
   */
  public static enum Topping {
    NO_TOPPING("No Topping"), PEPPERONI("Pepperoni"), HAM("Ham"), SAUSAGE("Sausage"), GREEN_PEPPER("Green Pepper"),
    ONION("Onion"), TOMATO("Tomato"), MUSHROOM("Mushroom"), PINEAPPLE("Pineapple");

    private final String name;

    private Topping(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  /**
   * Choices of whether or not the pizza contains cheese. The default value for
   * this property is the first item in this Enum.
   */
  public static enum CheeseOption {
    REG_CHEESE("Mozzarella Cheese"), EXTRA_CHEESE("Extra Mozzarella Cheese"), NO_CHEESE("No Cheese");

    private final String name;

    private CheeseOption(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  /**
   * Choices of red sauce. The default value for this property is the first item
   * in this Enum.
   */
  public static enum SauceOption {
    RED_SAUCE("Red Sauce"), NO_SAUCE("No Sauce");

    private final String name;

    private SauceOption(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  /**
   * Choices of crust. The default value for this property is the first item in
   * this Enum.
   */
  public static enum CrustOption {
    TRADITIONAL("Traditional"), THIN_CRUST("Thin Crust"), DEEP_DISH("Deep Dish");

    private final String name;

    private CrustOption(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  private final Size size;
  // default parameters:
  private CheeseOption cheese = CheeseOption.values()[0];
  private SauceOption sauce = SauceOption.values()[0];
  private CrustOption crust = CrustOption.values()[0];
  private Topping[] toppings = new Topping[MAX_TOPPINGS]; // 4 slots for topping choice.

  /**
   * Constructs a default pizza of the given size
   *
   * @param size Which pizza size to use. e.g. Pizza.Size.MEDIUM
   */
  public Pizza(Size size) {
    this.size = size;
  }

  public CrustOption getCrust() {
    return this.crust;
  }

  public Pizza setCrust(CrustOption crust) {
    this.crust = crust;
    return this; // return the pizza, so the setter is chainable
  }

  public CheeseOption getCheese() {
    return this.cheese;
  }

  public Pizza setCheese(CheeseOption cheese) {
    this.cheese = cheese;
    return this; // return the pizza, so the setter is chainable
  }

  public SauceOption getSauce() {
    return this.sauce;
  }

  public Pizza setSauce(SauceOption sauce) {
    this.sauce = sauce;
    return this; // return the pizza, so the setter is chainable
  }

  public int getToppingCount() {
    int count = 0;
    for (Topping t : toppings) {
      if (t != null && t != Topping.NO_TOPPING) {
        count += 1;
      }
    }
    return count;
  }

  public Topping getNthTopping(int n) {
    return this.toppings[n - 1];
  }

  /**
   * Sets the nth topping to the specified Topping n must be between 1 and
   * MAX_TOPPINGS.
   */
  public Pizza setNthTopping(int n, Topping t) {
    int i = n - 1;
    if (0 <= i && i < toppings.length) { // check that n is within bounds
      this.toppings[i] = t; // set nth topping
    }
    return this; // return the pizza, so the setter is chainable
  }

  public int getPrice() {
    return size.calculatePrice(getToppingCount());
  }

  public String getName() {
    return this.size.name;
  }

  public List<String> getDescriptionItems() {
    List<String> items = new ArrayList<String>();
    items.add(crust.toString());
    items.add(sauce.toString());
    items.add(cheese.toString());
    for (Topping t : toppings) {
      if (t != null && t != Topping.NO_TOPPING) {
        items.add(t.toString());
      }
    }
    return items;
  }
}
