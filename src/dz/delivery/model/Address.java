package dz.delivery.model;

import java.util.List;

public class Address {
    private int addressId;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private GeoPosition geoPosition; // Represents a one-to-one relationship with GeoPosition class

    // constructor method
    public Address(
        int addressId,
        String street,
        String city,
        String postalCode,
        String country,
        GeoPosition geoPosition
    ){
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.geoPosition = geoPosition;
    }

    // Getter and Setter for addressId
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    // Getter and Setter for street
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Getter and Setter for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for postalCode
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Getter and Setter for country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Getter and Setter for GeoPosition relationship
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

 
}

