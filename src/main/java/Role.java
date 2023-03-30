public class Role {
    int CPR, TopicID;
    String Role;
    String table;
    public Role(int CPR, int topicID, String role, String Table) {
        this.CPR = CPR;
        this.TopicID = topicID;
        this.Role = role;
        this.table = Table;
    }

    public int getCPR() {
        return CPR;
    }
    public String getTable() {
        return table;
    }

    public int getTopicID() {
        return TopicID;
    }

    public String getRole() {
        return Role;
    }
}
