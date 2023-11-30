package dz.delivery.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Client client; // Represents a many-to-one relationship with Client class
    private DeliveryGuy deliveryGuy; // Represents a many-to-one relationship with DeliveryGuy class
    private Address address; // Represents a many-to-one relationship with Address class
    private String status;
    private String review;
    private int evaluation;
    private Date createdAt;
    private Date confirmedAt;
    private Date deliveredAt;
    private List<OrderLine> orderLines;

    // Getter and Setter for orderId
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Add getters and setters for other properties (status, review, evaluation,
    // createdAt, confirmedAt, deliveredAt)...

    // Getter and Setter for Client relationship
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Getter and Setter for DeliveryGuy relationship
    public DeliveryGuy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(DeliveryGuy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }

    // Getter and Setter for Address relationship
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for review
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    // Getter and Setter for evaluation
    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    // Getter and Setter for createdAt
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // Getter and Setter for confirmedAt
    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    // Getter and Setter for deliveredAt
    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    // Getter and Setter for OrderLines relationship
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }





    // ....................................................;

    
}
