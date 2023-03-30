import java.sql.Time;

public class NewsItem {
    int NewsItemID, TopicID, NumberOfViews;
    Time TimeInEdition;
    String BriefDescription;
    String table;
    public NewsItem(int newsItemID, int topicID, Time timeInEdition,String briefDescription , int numberOfViews, String Table) {
        this.NewsItemID = newsItemID;
        this.TopicID = topicID;
        this.NumberOfViews = numberOfViews;
        this.TimeInEdition = timeInEdition;
        this.BriefDescription = briefDescription;
        this.table = Table;
    }

    public int getNewsItemID() {
        return NewsItemID;
    }
    public String getTable() {
        return table;
    }

    public int getTopicID() {
        return TopicID;
    }

    public int getNumberOfViews() {
        return NumberOfViews;
    }

    public Time getTimeInEdition() {
        return TimeInEdition;
    }

    public String getBriefDescription() {
        return BriefDescription;
    }
}
