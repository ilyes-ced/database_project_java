package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.Address;

public abstract class AddressDao {
    protected Connection con = null;

    public AddressDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(Address address);
    public abstract boolean delete(Address address);
    public abstract boolean update(Address address);
    public abstract Address find(int id);
}