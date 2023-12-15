package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.OrderLine;
import dz.delivery.model.Connector;


public class OrderLineDao extends Dao<OrderLine>{
    public OrderLineDao(Connection con) {
        super(con); 
    }


    public boolean create(OrderLine obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into OrderLines(order_id, item_id, quantity, photo_file_path) values (order_id=?, item_id=?, quantity=?, photo_file_path='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getOrder().getOrderId());
        pstmt.setDouble(2, obj.getItem().getItemId());
        pstmt.setInt(3, obj.getQuantity());
        pstmt.setString(4, obj.getPhotoFilePath());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(OrderLine obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from OrderLines where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getOrderLineId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(OrderLine obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update OrderLines set order_id=?, item_id=?, quantity=?, photo_file_path='?' where OrderLine_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getOrder().getOrderId());
        pstmt.setDouble(2, obj.getItem().getItemId());
        pstmt.setInt(3, obj.getQuantity());
        pstmt.setString(4, obj.getPhotoFilePath());
        pstmt.setInt(5, obj.getOrderLineId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public OrderLine find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int order_line_id = result.getInt("order_line_id");
        String order_id = result.getString("order_id");
        Double item_id = result.getDouble("item_id");
        int quantity = result.getInt("quantity");
        String photo_file_path = result.getString("photo_file_path");
        
            // simplified
            // corrrect way would be to also get the order and item
        return (new OrderLine(order_line_id, null, null, quantity, photo_file_path));
    }


    public ArrayList<OrderLine> findAll() throws SQLException {
        ArrayList<OrderLine> list = new ArrayList<OrderLine>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from geo_position";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int order_line_id = result.getInt("order_line_id");
            String order_id = result.getString("order_id");
            Double item_id = result.getDouble("item_id");
            int quantity = result.getInt("quantity");
            String photo_file_path = result.getString("photo_file_path");
            
            // simplified
            // corrrect way would be to also get the order and item
            list.add(new OrderLine(order_line_id, null, null, quantity, photo_file_path));
        }
        return list;
    }
}