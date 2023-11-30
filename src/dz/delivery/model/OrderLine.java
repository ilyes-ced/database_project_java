package dz.delivery.model;

public class OrderLine {
    private int orderLineId;
    private Order order; // Represents a many-to-one relationship with Order class
    private Item item; // Represents a many-to-one relationship with Item class
    private int quantity;
    private String photoFilePath;

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


}
