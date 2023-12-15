package dz.delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Order {
    public int orderId;
    public Client client; // Represents a many-to-one relationship with Client class
    public DeliveryGuy deliveryGuy; // Represents a many-to-one relationship with DeliveryGuy class
    public Address address_src; // Represents a many-to-one relationship with Address class
    public Address address_dist; // Represents a many-to-one relationship with Address class
    public String status;
    public String review;
    public int evaluation;
    public Date createdAt;
    public Date confirmedAt;
    public Date deliveredAt;
    public List<OrderLine> orderLines;



    // constructor
    public Order(
        int orderId,
        Client client,
        DeliveryGuy deliveryGuy,
        Address address_src,
        Address address_dist,
        String status,
        String review,
        int evaluation,
        Date createdAt,
        Date confirmedAt,
        Date deliveredAt,
        List<OrderLine> orderLines
    ){
        this.orderId = orderId;
        this.client = client;
        this.deliveryGuy = deliveryGuy;
        this.address_src = address_src;
        this.address_dist = address_dist;
        this.status = status;
        this.review = review;
        this.evaluation = evaluation;
        this.createdAt = createdAt;
        this.confirmedAt = confirmedAt;
        this.deliveredAt = deliveredAt;
        this.orderLines = orderLines;
    }


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
    public Address getAddressSrc() {
        return address_src;
    }

    public void setAddressSrc(Address address) {
        this.address_src = address;
    }
    // Getter and Setter for Address relationship
    public Address getAddressDist() {
        return address_dist;
    }

    public void setAddressDist(Address address) {
        this.address_dist = address;
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


    // Method to add an client for an order
    public void addClient(Client client) {
        if (!client.getOrders().contains(this)) {
            if(getClient() != null){
                removeClient(this);
            }
            setClient(client);
            client.addOrder(this);
        }
    }

    // Method to remove an client associated with a client
    public void removeClient(Order order) {
        getClient().removeOrder(this);
        setClient(null);
    }




    
 
    // Method to add an deleviry_guy for an order
    public void addDeliveryGuyy(DeliveryGuy deleviry_guy) {
        if (!deleviry_guy.getOrders().contains(this)) {
            if(getDeliveryGuy() != null){
                removeClient(this);
            }
            setDeliveryGuy(deleviry_guy);
            deleviry_guy.addOrder(this);
        }
    }

    // Method to remove an deleviry_guy associated with a deleviry_guy
    public void removeDeliveryGuy(DeliveryGuy deleviry_guy) {
        getDeliveryGuy().removeOrder(this);
        setDeliveryGuy(null);
    }

    








    // order lines

    public void addOrderLines(OrderLine orderline){
        if( !getOrderLines().contains(orderline) ){
           if(orderline.getOrder() != null) orderline.removeOrder();
           orderline.setOrder(this);
           getOrderLines().add(orderline);
        }
    }
    public void removeOrderLines(OrderLine orderline){
        if( getOrderLines().contains(orderline) ) { getOrderLines().remove(orderline); orderline.setOrder(null); }
    }







    // relation with address
    public void addSrcAddress(Address src_address) { setAddressSrc(src_address); }
    public void addDistAddress(Address dist_address) { setAddressDist(dist_address); }









    public void updateStatus(String status) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update orders set status='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, status);
        pstmt.setInt(2, this.getOrderId());
        int result = pstmt.executeUpdate();
    }

    public void addOrderLine(OrderLine orderLine) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql = "insert into order_lines(order_id,item_id,quantity,photo_file_path)"+
        "VALUES(?,?,?,'?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, this.getOrderId());
        pstmt.setInt(2, orderLine.getItem().getItemId());
        pstmt.setInt(3, orderLine.getQuantity());
        pstmt.setString(4, orderLine.getPhotoFilePath());
        int result = pstmt.executeUpdate();
    }




    public int getTotalPrice(Order order) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql = "select sum(price) from items where in (select id from order_lines where order_id=?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, this.getOrderId());
        ResultSet result = pstmt.executeQuery();
        int total_price = result.getInt(1);
        return total_price;
    }



}
