package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.Item;

public abstract class ItemDao {
    protected Connection con = null;

    public ItemDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(Item item);
    public abstract boolean delete(Item item);
    public abstract boolean update(Item item);
    public abstract Item find(int id);
}