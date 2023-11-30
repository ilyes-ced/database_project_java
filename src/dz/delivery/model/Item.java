package dz.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int itemId;
    private String name;
    private double price;
    private String description;
    private List<OrderLine> orderLines; // Represents a one-to-many relationship with OrderLine class




    // constructor
    public Item(
        int itemId,
        String name,
        double price,
        String description,
        List<OrderLine> orderLines
    ){
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.orderLines = orderLines;
    }

    // Getter and Setter for itemId
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Getter and Setter for OrderLines relationship

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

  public void addOrderLine(OrderLine orderLine) {
        if (orderLines == null) {
            orderLines = new ArrayList<>();
        }
        orderLines.add(orderLine);
        orderLine.setItem(this); // Assuming OrderLine class has a corresponding item field
    }


    









}
