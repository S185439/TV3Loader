public class Topic {
    int TopicID;
    String Title, BriefDescription;
    String table;
    public Topic(int topicID, String briefDescription, String title, String Table) {
        this.table = Table;
        this.TopicID = topicID;
        this.Title = title;
        this.BriefDescription = briefDescription;
    }

    public int getTopicID() {
        return TopicID;
    }
    public String getTable() {
        return table;
    }

    public String getTitle() {
        return Title;
    }

    public String getBriefDescription() {
        return BriefDescription;
    }
}
