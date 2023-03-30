public class Address {
    int AddressID, CityID, CivicNumber;
    String StreetName, table;


    public Address(int addressID, int cityID, String streetName, int civicNumber, String Table) {
        this.table = Table;
        this.AddressID = addressID;
        this.CityID = cityID;
        this.CivicNumber = civicNumber;
        this.StreetName = streetName;
    }

    public int getAddressID() {
        return AddressID;
    }

    public int getCityID() {
        return CityID;
    }

    public int getCivicNumber() {
        return CivicNumber;
    }

    public String getStreetName() {
        return StreetName;
    }
    public String getTable() {
        return table;
    }
}
