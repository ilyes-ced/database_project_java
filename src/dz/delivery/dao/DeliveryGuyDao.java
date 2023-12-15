package dz.delivery.dao;

import java.sql.Connection;

import dz.delivery.model.DeliveryGuy;

public abstract class DeliveryGuyDao {
    protected Connection con = null;

    public DeliveryGuyDao(Connection con){
        this.con = con;
    }

    public abstract boolean create(DeliveryGuy deliveryGuy);
    public abstract boolean delete(DeliveryGuy deliveryGuy);
    public abstract boolean update(DeliveryGuy deliveryGuy);
    public abstract DeliveryGuy find(int id);
}