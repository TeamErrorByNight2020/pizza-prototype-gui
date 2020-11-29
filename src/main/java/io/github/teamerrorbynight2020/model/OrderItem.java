package io.github.teamerrorbynight2020.model;

import java.text.NumberFormat;
import java.util.*;

/** An food/beverage item which can be put in a order */

public abstract class OrderItem {

  /** @return The name of the item */
  public abstract String getName();

  /** @return The price in cents of this item. */
  public abstract int getPrice();

  /** @return The price of this menu item as a formatted string i.e. $5.00 */
  public final String getPriceFormatted() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    return formatter.format(this.getPrice() / 100.0);
  }

  /**
   * @return A list of attributes (size, customizations, etc). The list may be empty.
   */
  public List<String> getDescriptionItems() {
    return new ArrayList<String>();
  }

  /**
   * @return A single-line description of the order item, separated by commas.
   */
  public final String getDescription() {
    return String.join(", ", getDescriptionItems());
  }
}