import java.sql.Time;
import java.util.Date;

public class Edition {
    int EditionID, CPR;
    java.sql.Date Date;
    Time Time, Length;
    String table;

    public Edition(int editionID, int CPR, java.sql.Date date, java.sql.Time length, java.sql.Time time, String Table) {
        this.EditionID = editionID;
        this.CPR = CPR;
        this.Date = date;
        this.Time = time;
        this.Length = length;
        this.table = Table;
    }

    public int getEditionID() {
        return EditionID;
    }
    public String getTable() {
        return table;
    }

    public int getCPR() {
        return CPR;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public java.sql.Time getLength() {
        return Length;
    }
}
