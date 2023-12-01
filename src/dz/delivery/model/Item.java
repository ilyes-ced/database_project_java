package dz.delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private int itemId;
    private String name;
    private double price;
    private String description;
    private List<OrderLine> orderLines; // Represents a one-to-many relationship with OrderLine class




    // constructor
    public Item(
        int itemId,
        String name,
        double price,
        String description,
        List<OrderLine> orderLines
    ){
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.orderLines = orderLines;
    }

    // Getter and Setter for itemId
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Getter and Setter for OrderLines relationship

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }


    

    
    // order line item relation
    public void addOrderLines(OrderLine orderline){
        if( !getOrderLines().contains(orderline) ){
            if(orderline.getItem() != null) orderline.removeItem();
            orderline.setItem(this);
            getOrderLines().add(orderline);
        }
    }
    public void removeOrderLines(OrderLine orderline){
        if( getOrderLines().contains(orderline) ) { getOrderLines().remove(orderline); orderline.setItem(null); }
    }
 








    public void updateStatus(double price, String name, String description) throws SQLException {
        Connection conn = Connector.get_conn();
        String sql ="update orders set price=?,name='?',description='?' where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, price);
        pstmt.setString(2, name);
        pstmt.setString(3, description);
        pstmt.setInt(4, this.getItemId());
        int result = pstmt.executeUpdate();
    }


}
