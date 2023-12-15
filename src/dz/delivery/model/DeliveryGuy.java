package dz.delivery.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
    

    // Method to retrieve all orders associated with this delivery guy
    public List<Order> getOrders() {
        return this.orders;
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
        int result = pstmt.executeUpdate();
    }
    // update password
    public void updatePassword(String password) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update agents set password='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setLong(2, this.getDeliveryGuyId());
        int result = pstmt.executeUpdate();
    }


    public void confirmDelivery(Order order) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update orders set delivered_at='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, (Date) Calendar.getInstance().getTime());
        pstmt.setInt(2, order.getOrderId());
        int result = pstmt.executeUpdate();
    }



    // not finished // complex
    // use joins
    public ArrayList<Order> getMyOrders() throws SQLException {
        Connection conn = Connector.get_conn();
        // nice query my best record
        String sql = "SELECT"+
            "o.order_id, o.client_id, o.delivery_guy_id, o.src_address_id, o.dist_address_id, o.status, o.review, o.evaluation, o.created_at, o.confirmed_at, o.delivered_at,"+
            "c.client_id as client_client_id, c.firstname as client_firstname, c.lastname as client_lastname, c.email as client_email, c.password as client_password, c.phone_number as client_phone_number, c.profile_photo_path as client_profile_photo_path,"+
            "d.delivery_guy_id as delivery_delivery_guy_id, d.firstname as delivery_firstname, d.lastname as delivery_lastname, d.email as delivery_email, d.password as delivery_password, d.phone_number as delivery_phone_number, d.status as delivery_status,"+
            "a_src.address_id as src_src_address_id, a_src.street as src_street, a_src.city as src_city, a_src.postal_code as src_postal_code, a_src.country as src_country, a_src.geo_position_id as src_geo_position_id,"+
            "a_dist.address_id as dist_dist_address_id, a_dist.street as dist_street, a_dist.city as dist_city, a_dist.postal_code as dist_postal_code, a_dist.country as dist_country, a_dist.geo_position_id as dist_geo_position_id,"+
            "geo_src.position_id as src_position_id, geo_src.latitude as src_latitude, geo_src.longitude as src_longitude,"+
            "geo_dist.position_id as dist_position_id, geo_dist.latitude as dist_latitude, geo_dist.longitude as dist_longitude"+
            "FROM orders o"+
            "LEFT JOIN clients c ON o.client_id = c.client_id"+
            "LEFT JOIN addresses a_src ON o.src_address_id = a_src.address_id"+
            "LEFT JOIN addresses a_dist ON o.dist_address_id = a_dist.address_id "+
            "LEFT JOIN geo_position geo_src ON o.src_address_id = geo_src.position_id"+
            "LEFT JOIN geo_position geo_dist ON o.dist_address_id = geo_dist.position_id "+
            "LEFT JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id "+
            "where d.delivery_guy_id = 1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, this.getDeliveryGuyId());
        
        ResultSet resultSet = pstmt.executeQuery();

        ArrayList<Order> my_order = new ArrayList<Order>();
        // Process the Results
        while (resultSet.next()) {
            Order order = new Order(
                resultSet.getInt("order_id"),
                new Client(
                    resultSet.getInt("client_client_id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("profile_photo_path"),
                    new ArrayList<Order>()
                ),
                new DeliveryGuy(
                    resultSet.getInt("delivery_delivery_guy_id"),
                    resultSet.getString("delivery_firstname"),
                    resultSet.getString("delivery_lastname"),
                    resultSet.getString("delivery_email"),
                    resultSet.getString("delivery_password"),
                    resultSet.getString("delivery_phone_number"),
                    resultSet.getString("delivery_status"),
                    new ArrayList<Order>()
                ),
                new Address(
                    resultSet.getInt("src_src_position_id"),
                    resultSet.getString("src_street"),
                    resultSet.getString("src_city"),
                    resultSet.getString("src_postal_code"),
                    resultSet.getString("src_country"),
                    new GeoPosition(
                        resultSet.getInt("src_address_id"),
                        resultSet.getDouble("src_latitude"),
                        resultSet.getDouble("src_longitude")
                    )
                ),
                new Address(
                    resultSet.getInt("dist_dist_address_id"),
                    resultSet.getString("dist_street"),
                    resultSet.getString("dist_city"),
                    resultSet.getString("dist_postal_code"),
                    resultSet.getString("dist_country"),
                    new GeoPosition(
                        resultSet.getInt("dist_address_id"),
                        resultSet.getDouble("dist_latitude"),
                        resultSet.getDouble("dist_longitude")
                    )
                ),
                resultSet.getString("status"),
                resultSet.getString("review"),
                resultSet.getInt("evaluation"),
                resultSet.getDate("created_at"),
                resultSet.getDate("confirmed_at"),
                resultSet.getDate("delivered_at"),
                new ArrayList<OrderLine>()
            );
            my_order.add(order);
        }
        return my_order;
    }

}
