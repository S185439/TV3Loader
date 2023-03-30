public class City {
    int CityID, ZIPCode;
    String Country;
    String table;

    public City(int cityID, String country, int ZIPCode, String Table) {
        this.table = Table;
        this.CityID = cityID;
        this.ZIPCode = ZIPCode;
        this.Country = country;
    }

    public int getCityID() {
        return CityID;
    }

    public int getZIPCode() {
        return ZIPCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getTable() {
        return table;
    }
}
