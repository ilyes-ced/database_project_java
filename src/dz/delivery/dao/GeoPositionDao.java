package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.GeoPosition;

public abstract class GeoPositionDao {
    protected Connection con = null;

    public GeoPositionDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(GeoPosition geoPosition);
    public abstract boolean delete(GeoPosition geoPosition);
    public abstract boolean update(GeoPosition geoPosition);
    public abstract GeoPosition find(int id);
}