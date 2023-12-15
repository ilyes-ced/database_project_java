package dz.delivery.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.Order;
import dz.delivery.model.OrderLine;
import dz.delivery.model.Connector;


public class OrderDao extends Dao<Order>{
    public OrderDao(Connection con) {
        super(con); 
    }


    public boolean create(Order obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into Order(client_id, delivery_guy_id, src_address_id, dist_address_id, status, review, evaluation, created_at, confirmed_at, delivered_at) values (client_id=? ,delivery_guy_id=? ,src_address_id=?, dist_address_id=?, status='?', review='?', evaluation=?, created_at=?, confirmed_at=?, delivered_at=?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getClient().getClientId());
        pstmt.setInt(2, obj.getDeliveryGuy().getDeliveryGuyId());
        pstmt.setInt(3, obj.getAddressSrc().getAddressId());
        pstmt.setInt(4, obj.getAddressDist().getAddressId());
        pstmt.setString(5, obj.getStatus());
        pstmt.setString(6, obj.getReview());
        pstmt.setDouble(7, obj.getEvaluation());
        pstmt.setDate(8, (Date) obj.getCreatedAt());
        pstmt.setDate(9, (Date) obj.getConfirmedAt());
        pstmt.setDate(10, (Date) obj.getDeliveredAt());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Order obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from orders where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getOrderId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(Order obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update Orderss set client_id=? ,delivery_guy_id=? ,src_address_id=?, dist_address_id=?, status='?', review='?', evaluation=?, created_at=?, confirmed_at=?, delivered_at=? where Orders_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getClient().getClientId());
        pstmt.setInt(2, obj.getDeliveryGuy().getDeliveryGuyId());
        pstmt.setInt(3, obj.getAddressSrc().getAddressId());
        pstmt.setInt(4, obj.getAddressDist().getAddressId());
        pstmt.setString(5, obj.getStatus());
        pstmt.setString(6, obj.getReview());
        pstmt.setDouble(7, obj.getEvaluation());
        pstmt.setDate(8, (Date) obj.getCreatedAt());
        pstmt.setDate(9, (Date) obj.getConfirmedAt());
        pstmt.setDate(10, (Date) obj.getDeliveredAt());
        pstmt.setInt(11, obj.getOrderId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public Order find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();


        int orderId = result.getInt("order_id");
        int client = result.getInt("client_id");
        int deliverGuy = result.getInt("delivery_guy_id");
        int address_src = result.getInt("src_address_id");
        int address_dist = result.getInt("dist_address_id");
        String status = result.getString("status");
        String review = result.getString("review");
        int evaluation = result.getInt("evaluation");
        Date createdAt = result.getDate("created_at");
        Date confirmedAt = result.getDate("confirmed_at");
        Date deliveredAt = result.getDate("delivered_at");


        // simplified
        // corrrect way would be to also get the client, deliveryguy and addresses
        return (new Order(orderId, null, null, null, null, status, review, evaluation, createdAt, confirmedAt, deliveredAt, new ArrayList<OrderLine>()));
    }


    public ArrayList<Order> findAll() throws SQLException {
        ArrayList<Order> list = new ArrayList<Order>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from orders";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int orderId = result.getInt("order_id");
            int client = result.getInt("client_id");
            int deliverGuy = result.getInt("delivery_guy_id");
            int address_src = result.getInt("src_address_id");
            int address_dist = result.getInt("dist_address_id");
            String status = result.getString("status");
            String review = result.getString("review");
            int evaluation = result.getInt("evaluation");
            Date createdAt = result.getDate("created_at");
            Date confirmedAt = result.getDate("confirmed_at");
            Date deliveredAt = result.getDate("delivered_at");

            
            // simplified
            // corrrect way would be to also get the client, deliveryguy and addresses
            list.add(new Order(orderId, null, null, null, null, status, review, evaluation, createdAt, confirmedAt, deliveredAt, new ArrayList<OrderLine>()));
        }
        return list;
    }
}