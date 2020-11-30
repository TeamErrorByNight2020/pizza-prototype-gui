package io.github.teamerrorbynight2020.model;

import java.text.NumberFormat;
import java.util.*;

/** An food/beverage item which can be put in a order */

public abstract class OrderItem {

  public static String formatPriceString(int price) {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    return formatter.format(price / 100.0);
  }

  /** @return The name of the item */
  public abstract String getName();

  /** @return The price in cents of this item. */
  public abstract int getPrice();

  /** @return The price of this menu item as a formatted string i.e. $5.00 */
  public final String getPriceFormatted() {
    return formatPriceString(this.getPrice());
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
    if (getDescriptionItems().isEmpty()) {
      return "";
    }
    return String.join(", ", getDescriptionItems());
  }


  @Override
  public String toString() {
    return getName() + "\n" + (getDescription().length() > 0 ? getDescription() + "\n" : "") + getPriceFormatted();
  }
}