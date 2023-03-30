public class ConnectedFootage {
    int FootageID, NewsItemID;
    String table;
    public ConnectedFootage(int footageID, int newsItemID, String Table) {
        this.table = Table;
        this.FootageID = footageID;
        this.NewsItemID = newsItemID;
    }

    public int getFootageID() {
        return FootageID;
    }

    public int getNewsItemID() {
        return NewsItemID;
    }
    public String getTable() {
        return table;
    }
}
