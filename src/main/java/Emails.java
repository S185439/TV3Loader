public class Emails {
    int CPR;
    String Email;
    String table;
    public Emails(String email, int CPR, String Table) {
        this.CPR = CPR;
        this.Email = email;
        this.table = Table;
    }

    public int getCPR() {
        return CPR;
    }

    public String getEmail() {
        return Email;
    }
    public String getTable() {
        return table;
    }
}
