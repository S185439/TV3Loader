public class ConnectedNewsItems {
    int EditionID, NewsItemID;
    String table;
    public ConnectedNewsItems(int editionID, int newsItemID, String Table) {
        this.table = Table;
        this.EditionID = editionID;
        this.NewsItemID = newsItemID;
    }

    public int getEditionID() {
        return EditionID;
    }

    public int getNewsItemID() {
        return NewsItemID;
    }
    public String getTable() {
        return table;
    }
}
