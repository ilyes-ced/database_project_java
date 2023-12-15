package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.OrderLine;

public abstract class OrderLineDao {
    protected Connection con = null;

    public OrderLineDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(OrderLine orderLine);
    public abstract boolean delete(OrderLine orderLine);
    public abstract boolean update(OrderLine orderLine);
    public abstract OrderLine find(int id);
}