package dz.delivery.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao<T> {
protected Connection con = null;
    public Dao(Connection con){
        this.con = con;
    }
    public abstract boolean create(T obj) throws SQLException;
    public abstract boolean delete(T obj) throws SQLException;
    public abstract boolean update(T obj) throws SQLException;
    public abstract T find(int id) throws SQLException;
}