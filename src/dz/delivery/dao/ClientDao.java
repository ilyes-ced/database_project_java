package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.Client;
import dz.delivery.model.Connector;
import dz.delivery.model.GeoPosition;
import dz.delivery.model.Order;

public class ClientDao extends Dao<Client>{
    public ClientDao(Connection con) {
        super(con); 
    }


    public boolean create(Client obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into Clients(firstname, lastname, email, password, phoneNumber, profile_photo_path) values (firstname='?', lastname='?', email='?', password='?', phoneNumber='?', profile_photo_path='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());
        pstmt.setString(6, obj.getProfilePhotoPath());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Client obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from Clients where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getClientId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(Client obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update Clients set firstname='?', lastname='?', email='?', password='?', phone_number='?', ip_addr='?' where Client_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());
        pstmt.setString(6, obj.getProfilePhotoPath());
        pstmt.setInt(7, obj.getClientId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public Client find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int ClientId = result.getInt("ClientId");
        String firstname = result.getString("firstname");
        String lastname = result.getString("lastname");
        String email = result.getString("email");
        String password = result.getString("password");
        String phoneNumber = result.getString("phoneNumber");
        String profile_photo_path = result.getString("profile_photo_path");
        return (new Client(ClientId, firstname, lastname, email, password, phoneNumber, profile_photo_path, new ArrayList<Order>()));
    }


    public ArrayList<Client> findAll() throws SQLException {
        ArrayList<Client> list = new ArrayList<Client>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from Clients";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int ClientId = result.getInt("ClientId");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            String phoneNumber = result.getString("phoneNumber");
            String profile_photo_path = result.getString("profile_photo_path");
            list.add(new Client(ClientId, firstname, lastname, email, password, phoneNumber, profile_photo_path, new ArrayList<Order>()));
        }
        return list;
    }
}