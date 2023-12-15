package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.DeliveryGuy;
import dz.delivery.model.Connector;
import dz.delivery.model.GeoPosition;
import dz.delivery.model.Order;

public class DeliveryGuyDao extends Dao<DeliveryGuy>{
    public DeliveryGuyDao(Connection con) {
        super(con); 
    }


    public boolean create(DeliveryGuy obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into DeliveryGuys(firstname, lastname, email, password, phoneNumber) values (firstname='?', lastname='?', email='?', password='?', phoneNumber='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(DeliveryGuy obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from DeliveryGuys where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getDeliveryGuyId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(DeliveryGuy obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update DeliveryGuys set firstname='?', lastname='?', email='?', password='?', phone_number='?', status='?' where DeliveryGuy_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());
        pstmt.setString(6, obj.getStatus());
        pstmt.setInt(7, obj.getDeliveryGuyId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public DeliveryGuy find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int DeliveryGuyId = result.getInt("DeliveryGuyId");
        String firstname = result.getString("firstname");
        String lastname = result.getString("lastname");
        String email = result.getString("email");
        String password = result.getString("password");
        String phoneNumber = result.getString("phoneNumber");
        String status = result.getString("status");
        return (new DeliveryGuy(DeliveryGuyId, firstname, lastname, email, password, phoneNumber, status, new ArrayList<Order>()));
    }


    public ArrayList<DeliveryGuy> findAll() throws SQLException {
        ArrayList<DeliveryGuy> list = new ArrayList<DeliveryGuy>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from DeliveryGuys";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int DeliveryGuyId = result.getInt("DeliveryGuyId");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            String phoneNumber = result.getString("phoneNumber");
            String status = result.getString("status");
            list.add(new DeliveryGuy(DeliveryGuyId, firstname, lastname, email, password, phoneNumber, status, new ArrayList<Order>()));
        }
        return list;
    }
}