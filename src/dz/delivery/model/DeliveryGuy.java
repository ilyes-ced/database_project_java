package dz.delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


    // Method to add an order for a client
    public void addOrder(Order order) {
        if( !getOrders().contains(order) ){
            if(order.getClient() != null) order.removeClient(order);
            order.setDeliveryGuy(this);
            orders.add(order);
        }
    }

    // Method to remove an order associated with a client
    public void removeOrder(Order order) {
        if(getOrders().contains(order)){
            getOrders().remove(order);
            order.setDeliveryGuy(null);
        }
    }

    // Method to retrieve all orders associated with this delivery guy
    public List<Order> getOrders() {
        return orders;
    }















        // update user agent
    public void updateUser(
        String firstname,
        String lastname,
        String email,
        String password,
        String phoneNumber,
        String status
    ) throws SQLException {
        Connection conn = Connector.get_conn();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;


        String sql ="update agents set firstname='?', lastname='?', email='?', password='?', phoneNumber='?', ipaddr='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, this.getFirstname());
        pstmt.setString(2, this.getLastname());
        pstmt.setString(3, this.getEmail());
        pstmt.setString(4, this.getPassword());
        pstmt.setString(5, this.getPhoneNumber());
        pstmt.setString(6, this.getStatus());
        pstmt.setInt(7, this.getDeliveryGuyId());
        ResultSet result = pstmt.executeQuery();
    }
    // update password
    public void updatePassword(String password) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update agents set password='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setLong(2, this.getDeliveryGuyId());
        ResultSet result = pstmt.executeQuery();
    }


    public void confirmDelivery(Order order) {
        //database methode
    }
    public void getMyOrders(Order order) {
        //database methode
    }

}
