public class Journalist {
    int CPR, AdressID;
    String FirstName, LastName;
    String table;

    public Journalist(int CPR, int addressID, String firstName, String lastName, String Table) {
        this.CPR = CPR;
        this.AdressID = addressID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.table = Table;
    }

    public int getCPR() {
        return CPR;
    }
    public String getTable() {
        return table;
    }

    public int getAdressID() {
        return AdressID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
}
