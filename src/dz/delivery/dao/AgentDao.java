package dz.delivery.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import dz.delivery.model.Address;
import dz.delivery.model.Agent;
import dz.delivery.model.Connector;
import dz.delivery.model.GeoPosition;

public class AgentDao extends Dao<Agent>{
    public AgentDao(Connection con) {
        super(con); 
    }


    public boolean create(Agent obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="insert into agents(firstname, lastname, email, password, phoneNumber, ipAddr) values (firstname='?', lastname='?', email='?', password='?', phoneNumber='?', ipAddr='?')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());
        pstmt.setString(6, obj.getIpAddr());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Agent obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="delete from agents where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, obj.getAgentId());
        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean update(Agent obj) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update agents set firstname='?', lastname='?', email='?', password='?', phone_number='?', ip_addr='?' where agent_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, obj.getFirstname());
        pstmt.setString(2, obj.getLastname());
        pstmt.setString(3, obj.getEmail());
        pstmt.setString(4, obj.getPassword());
        pstmt.setString(5, obj.getPhoneNumber());
        pstmt.setString(6, obj.getIpAddr());
        pstmt.setInt(7, obj.getAgentId());

        int result = pstmt.executeUpdate();
        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public Agent find(int id) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="select from addresses where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery(sql);
        
        result.next();
        int agentId = result.getInt("AgentId");
        String firstname = result.getString("firstname");
        String lastname = result.getString("lastname");
        String email = result.getString("email");
        String password = result.getString("password");
        String phoneNumber = result.getString("phoneNumber");
        String ipAddr = result.getString("ipAddr");
        return (new Agent(agentId, firstname, lastname, email, password, phoneNumber, ipAddr));
    }


    public ArrayList<Agent> findAll() throws SQLException {
        ArrayList<Agent> list = new ArrayList<Agent>();
        
        Connection conn = Connector.get_conn();
        String sql ="select * from Agents";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while(result.next()){
            int agentId = result.getInt("AgentId");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            String phoneNumber = result.getString("phoneNumber");
            String ipAddr = result.getString("ipAddr");
            list.add(new Agent(agentId, firstname, lastname, email, password, phoneNumber, ipAddr));
        }
        return list;
    }
}