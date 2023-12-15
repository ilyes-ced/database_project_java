package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.Order;

public abstract class OrderDao {
    protected Connection con = null;

    public OrderDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(Order order);
    public abstract boolean delete(Order order);
    public abstract boolean update(Order order);
    public abstract Order find(int id);
}