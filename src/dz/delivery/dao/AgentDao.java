package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.Agent;

public abstract class AgentDao {
    protected Connection con = null;

    public AgentDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(Agent agent);
    public abstract boolean delete(Agent agent);
    public abstract boolean update(Agent agent);
    public abstract Agent find(int id);
}