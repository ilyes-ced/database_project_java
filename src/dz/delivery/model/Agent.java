package dz.delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Agent {
    private int agentId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String ipAddr;


    // constructor method
    public Agent(
        int agentId,
        String firstname,
        String lastname,
        String email,
        String password,
        String phoneNumber,
        String ipAddr
    ){
        this.agentId = agentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.ipAddr = ipAddr;
    }

    // Getter and Setter for agentId
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
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

    // Getter and Setter for ipAddr
    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    // Other methods...













    // update user agent
    public void updateUser(
        String firstname,
        String lastname,
        String email,
        String password,
        String phoneNumber,
        String ipAddr
    ) throws SQLException {
        Connection conn = Connector.get_conn();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.ipAddr = ipAddr;


        String sql ="update agents set firstname='?', lastname='?', email='?', password='?', phone_number='?', ip_addr='?' where agent_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, this.getFirstname());
        pstmt.setString(2, this.getLastname());
        pstmt.setString(3, this.getEmail());
        pstmt.setString(4, this.getPassword());
        pstmt.setString(5, this.getPhoneNumber());
        pstmt.setString(6, this.getIpAddr());
        pstmt.setInt(7, this.getAgentId());
        int result = pstmt.executeUpdate();
    }
    // update password
    public void updatePassword(String password) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update agents set password='?' where agent_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setLong(2, this.getAgentId());
        int result = pstmt.executeUpdate();
    }





    public void createClient(Client client) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="INSERT INTO clients(firstname, lastname, email, password, phoneNumber, profile_photo_path) VALUES('?','?',?,'?','?','?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, client.getFirstname());
        pstmt.setString(2, client.getLastname());
        pstmt.setString(3, client.getEmail());
        pstmt.setString(4, client.getPassword());
        pstmt.setString(5, client.getPhoneNumber());
        pstmt.setString(6, client.getProfilePhotoPath());
        int result = pstmt.executeUpdate();
    }

    public void createDeliveryGuy(DeliveryGuy deliveryGuy) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="INSERT INTO clients(firstname, lastname, email, password, phoneNumber, status) VALUES('?','?',?,'?','?','?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, deliveryGuy.getFirstname());
        pstmt.setString(2, deliveryGuy.getLastname());
        pstmt.setString(3, deliveryGuy.getEmail());
        pstmt.setString(4, deliveryGuy.getPassword());
        pstmt.setString(5, deliveryGuy.getPhoneNumber());
        pstmt.setString(6, deliveryGuy.getStatus());
        int result = pstmt.executeUpdate();
    }
    
    public void createItem(Item item) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="INSERT INTO clients(price,name,description) VALUES('?','?',?,'?','?','?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, item.getPrice());
        pstmt.setString(2, item.getName());
        pstmt.setString(3, item.getDescription());
        int result = pstmt.executeUpdate();
    }
}
