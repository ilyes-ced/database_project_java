package dz.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class DeliveryGuy {
    private int deliveryGuyId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String status;
    private List<Order> orders;


    // constructor method
    public DeliveryGuy(
        int deliveryGuyId,
        String firstname,
        String lastname,
        String email,
        String password,
        String phoneNumber,
        String status,
        List<Order> orders
    ){
        this.deliveryGuyId = deliveryGuyId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.orders = orders;
    }


    // Getter and Setter for deliveryGuyId
    public int getDeliveryGuyId() {
        return deliveryGuyId;
    }

    public void setDeliveryGuyId(int deliveryGuyId) {
        this.deliveryGuyId = deliveryGuyId;
    }

    // Getter and Setter for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter and Setter for lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    


    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


   public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setDeliveryGuy(this); // Assuming Order class has a corresponding deliveryGuy field
    }

    // Method to remove an order associated with a delivery guy
    public void removeOrder(Order order) {
        if (orders != null) {
            orders.remove(order);
            order.setDeliveryGuy(null); // Clear the association with this delivery guy
        }
    }

    // Method to retrieve all orders associated with this delivery guy
    public List<Order> getOrders() {
        return orders;
    }

}
