package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.Client;

public abstract class ClientDao {
    protected Connection con = null;

    public ClientDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(Client client);
    public abstract boolean delete(Client client);
    public abstract boolean update(Client client);
    public abstract Client find(int id);
}