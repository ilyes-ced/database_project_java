package dz.delivery.model;


public class GeoPosition {
    private int positionId;
    private double latitude;
    private double longitude;

    // constructor
    public GeoPosition(
        int positionId,    
        double latitude,
        double longitude
    ){
        this.positionId = positionId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter and Setter for positionId
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    // Getter and Setter for latitude
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter and Setter for longitude
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



}
