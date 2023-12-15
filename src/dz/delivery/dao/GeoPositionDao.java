package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.GeoPosition;
import dz.delivery.model.Connector;


public class GeoPositionDao extends Dao<GeoPosition>{
    public GeoPositionDao(Connection con) {
        super(con); 
    }


    public boolean create(GeoPosition obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into geo_position(latitude, longitude) values (latitude=?, longitude=?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, obj.getLatitude());
        pstmt.setDouble(2, obj.getLatitude());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(GeoPosition obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from geo_position where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getPositionId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(GeoPosition obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update geo_position set latitude=?, longitude=? where position_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, obj.getLatitude());
        pstmt.setDouble(2, obj.getLongitude());
        pstmt.setInt(3, obj.getPositionId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public GeoPosition find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int GeoPositionId = result.getInt("position_id");
        Double latitude = result.getDouble("latitude");
        Double longitude = result.getDouble("longitude");
        return (new GeoPosition(GeoPositionId, latitude, longitude));
    }


    public ArrayList<GeoPosition> findAll() throws SQLException {
        ArrayList<GeoPosition> list = new ArrayList<GeoPosition>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from geo_position";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int GeoPositionId = result.getInt("position_id");
            Double latitude = result.getDouble("latitude");
            Double longitude = result.getDouble("longitude");
            list.add(new GeoPosition(GeoPositionId, latitude, longitude));
        }
        return list;
    }
}