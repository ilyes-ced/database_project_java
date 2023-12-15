package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.Item;
import dz.delivery.model.OrderLine;
import dz.delivery.model.Connector;


public class ItemDao extends Dao<Item>{
    public ItemDao(Connection con) {
        super(con); 
    }


    public boolean create(Item obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into items(name, price, description) values (name='?', price=?, description='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getName());
        pstmt.setDouble(2, obj.getPrice());
        pstmt.setString(3, obj.getDescription());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Item obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from items where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getItemId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(Item obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update items set name='?', price=?, description='?' where item_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getName());
        pstmt.setDouble(2, obj.getPrice());
        pstmt.setString(3, obj.getDescription());
        pstmt.setInt(4, obj.getItemId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public Item find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int ItemId = result.getInt("item_id");
        String name = result.getString("name");
        Double price = result.getDouble("price");
        String description = result.getString("description");
        return (new Item(ItemId, name, price, description, new ArrayList<OrderLine>()));
    }


    public ArrayList<Item> findAll() throws SQLException {
        ArrayList<Item> list = new ArrayList<Item>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from geo_position";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int ItemId = result.getInt("item_id");
            String name = result.getString("name");
            Double price = result.getDouble("price");
            String description = result.getString("description");
            list.add(new Item(ItemId, name, price, description, new ArrayList<OrderLine>()));
        }
        return list;
    }
}