package dz.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePhotoPath;
    private List<Order> orders; // Represents a one-to-many relationship with Order class

    // constructor method
    public Client(
        int clientId,    
        String firstname,
        String lastname,
        String email,
        String password,
        String phoneNumber,
        String profilePhotoPath,
        List<Order> orders
    ){
        this.clientId = clientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profilePhotoPath = profilePhotoPath;
        this.orders = orders;
    }

    // Getter and Setter for clientId
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    // Getter and Setter for profilePhotoPath
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }



    // Method to add an order for a client
    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setClient(this); // Assuming Order class has a corresponding client field
    }

    // Method to remove an order associated with a client
    public void removeOrder(Order order) {
        if (orders != null) {
            orders.remove(order);
            order.setClient(null); // Clear the association with this client
        }
    }

    // Method to retrieve all orders associated with this client
    public List<Order> getOrders() {
        return orders;
    }
    
    // Method to set all orders associated with this client
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }





    public void createOrder(Order order) {
        //database methode
    }
    public void confirmOrders(Order order) {
        //database methode
    }
    public void review(Order order) {
        //database methode
    }

}
