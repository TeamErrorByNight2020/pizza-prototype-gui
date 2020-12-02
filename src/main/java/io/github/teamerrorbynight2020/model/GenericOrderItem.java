package io.github.teamerrorbynight2020.model;
public class GenericOrderItem extends OrderItem {
  private String name;
  private int price;

  public GenericOrderItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getPrice() {
    return this.price;
  }
}
