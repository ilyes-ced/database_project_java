package dz.delivery.model;

import java.util.List;

public class OrderLine {
    private int orderLineId;
    private Order order; // Represents a many-to-one relationship with Order class
    private Item item; // Represents a many-to-one relationship with Item class
    private int quantity;
    private String photoFilePath;



    // constructor
    public OrderLine(
        int orderLineId,
        Order order,
        Item item,
        int quantity,
        String photoFilePath
    ){
        this.orderLineId = orderLineId;
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.photoFilePath = photoFilePath;
    }


    // Getter and Setter for orderLineId
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    // Getter and Setter for Order relationship
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Getter and Setter for Item relationship
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter for photoFilePath
    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }





    public void addOrder(Order order){
        if(!order.getOrderLines().contains(this)){
            if(getOrder() != null) removeOrder();
            setOrder(order);
            order.addOrderLine(this);
        }
    }
    public void removeOrder(){ getOrder().removeOrderLine(this); setOrder(null); }







}