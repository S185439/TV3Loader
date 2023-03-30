import java.sql.Date;
import java.sql.Time;

public class Footage {
    int FootageID, CPR;
    String Title;
    Date Date;
    Time Duration;
    String table;
    public Footage(int footageID, int CPR, String title, java.sql.Date date, Time duration, String Table) {
        this.FootageID = footageID;
        this.CPR = CPR;
        this.Title = title;
        this.Date = date;
        this.Duration = duration;
        this.table = Table;
    }

    public int getFootageID() {
        return FootageID;
    }
    public String getTable() {
        return table;
    }

    public int getCPR() {
        return CPR;
    }

    public String getTitle() {
        return Title;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public Time getDuration() {
        return Duration;
    }
}
