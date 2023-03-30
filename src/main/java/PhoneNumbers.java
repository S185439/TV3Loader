public class PhoneNumbers {
    int CPR;
    String CountryCode, PhoneNumber;
    String table;
    public PhoneNumbers(String countryCode, String phoneNumber, int CPR, String Table) {
        this.CPR = CPR;
        this.CountryCode = countryCode;
        this.PhoneNumber = phoneNumber;
        this.table = Table;
    }

    public int getCPR() {
        return CPR;
    }
    public String getTable() {
        return table;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
