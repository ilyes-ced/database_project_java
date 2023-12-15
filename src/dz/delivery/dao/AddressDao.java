//package dz.delivery.dao;
//
//import java.sql.Connection;
//
//import dz.delivery.model.Address;
//
//public abstract class AddressDao {
//    protected Connection con = null;
//
//    public AddressDao(Connection con){
//        this.con = con;
//    }
//
//    public abstract boolean create(Address address);
//    public abstract boolean delete(Address address);
//    public abstract boolean update(Address address);
//    public abstract Address find(int id);
//}
package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.Connector;
import dz.delivery.model.GeoPosition;

public class AddressDao extends Dao<Address>{
    public AddressDao(Connection con) {
        super(con); 
    }


    public boolean create(Address obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into addresses(street, city, postal_code, country, geo_position_id) values (street='?', city='?', postal_code='?', country='?', geo_position_id='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getStreet());
        pstmt.setString(2, obj.getCity());
        pstmt.setString(3, obj.getPostalCode());
        pstmt.setString(4, obj.getCountry());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Address obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from adresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getAddressId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(Address obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update addresses set street='?', city='?', postal_code='?', country='?', geo_position_id='?' where agent_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getStreet());
        pstmt.setString(2, obj.getCity());
        pstmt.setString(3, obj.getPostalCode());
        pstmt.setString(4, obj.getCountry());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public Address find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int addressId = result.getInt("addressId");
        String street = result.getString("street");
        String city = result.getString("city");
        String postalCode = result.getString("postalCode");
        String country = result.getString("country");
        int geoPosition = result.getInt("geoPosition");
        return (new Address(addressId, street, city, postalCode, country, new GeoPosition(geoPosition, addressId, geoPosition)));
    }


    public ArrayList<Address> findAll() {
        ArrayList<Address> list = new ArrayList<Address>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from addresses";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery("SELECT * FROM address");

        while(result.next()){
            int id = result.getInt("id");
            String nom = result.getString("nom");
            int prenom = result.getInt("prenom");


            list.add(new Address(..., ...));
        }
        return list;
    }
}