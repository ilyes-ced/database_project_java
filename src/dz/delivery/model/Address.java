package dz.delivery.model;


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

 












    public String toString() {
        return this.country + " " + this.city + " " + this.street + " " + this.postalCode ;
    }
    public int getMyWilayaCode() {
        switch (this.city) {
            case "Adrar": return    1; 
            case "Chlef": return 2; 
            case "Laghouat": return 3; 
            case "Oum El Bouaghi": return 4; 
            case "Batna": return 5; 
            case "Béjaïa": return 6; 
            case "Biskra": return 7; 
            case "Béchar": return 8; 
            case "Blida": return 9; 
            case "Bouïra": return 10; 
            case "Tamanrasset": return 11; 
            case "Tébessa": return 12; 
            case "Tlemcen": return 13; 
            case "Tiaret": return 14; 
            case "Tizi Ouzou": return 15; 
            case "Algiers": return 16; 
            case "Djelfa": return 17; 
            case "Jijel": return 18; 
            case "Sétif": return 19; 
            case "Saïda": return 20; 
            case "Skikda": return 21; 
            case "Sidi Bel Abbès": return 22; 
            case "Annaba": return 23; 
            case "Guelma": return 24; 
            case "Constantine": return 25; 
            case "Médéa": return 26; 
            case "Mostaganem": return 27; 
            case "M'Sila": return 28; 
            case "Mascara": return 29; 
            case "Ouargla": return 30; 
            case "Oran": return 31; 
            case "El Bayadh": return 32; 
            case "Illizi": return 33; 
            case "Bordj Bou Arréridj": return 34; 
            case "Boumerdès": return 35; 
            case "El Tarf": return 36; 
            case "Tindouf": return 37; 
            case "Tissemsilt": return 38; 
            case "El Oued": return 39; 
            case "Khenchela": return 40; 
            case "Souk Ahras": return 41; 
            case "Tipaza": return 42; 
            case "Mila": return 43; 
            case "Aïn Defla": return 44; 
            case "Naâma": return 45; 
            case "Aïn Témouchent": return 46; 
            case "Ghardaïa": return 47; 
            case "Relizane": return 48; 
            case "Timimoun": return 49; 
            case "Bordj Badji Mokhtar": return 50; 
            case "Ouled Djellal": return 51; 
            case "Béni Abbès": return 52; 
            case "Ain Salah": return 53; 
            case "Ain Guezzam": return 54; 
            case "Touggourt": return 55; 
            case "Djanet": return 56; 
            case "El M'Ghair": return 57; 
            case "El Menia": return 58; 
            default: return 0;
       }
    }


}

