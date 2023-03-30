import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class TV3InfoLoader {

    public static void main(String[] args) {


        TV3InfoReader loader = new TV3InfoReader();
        String host = "localhost";
        String port = "3306";
        String database = "TV3";
        //Write own username
        String username = "";
        //Write own password
        String password = "";
        String cp = "utf8";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=" + cp;

        String filePath = "src\\main\\java\\Mock data - Ark1.csv";



        Connection connection = null;



        try {
            System.out.println(filePath);
            loader.readFile(filePath);
            ArrayList<Address> addresses = loader.getAddress();
            ArrayList<City> cities = loader.getCity();
            ArrayList<ConnectedFootage> conFootage = loader.getConnectedFootage();
            ArrayList<ConnectedNewsItems> conNewsItems = loader.getConnectedNewsItems();
            ArrayList<Country> countries = loader.getCountry();
            ArrayList<Edition> editions = loader.getEdition();
            ArrayList<Emails> emails = loader.getEmails();
            ArrayList<Footage> footage = loader.getFootage();
            ArrayList<Journalist> journalists = loader.getJournalist();
            ArrayList<NewsItem> newsItems = loader.getNewsItem();
            ArrayList<PhoneNumbers> phoneNumbers = loader.getPhoneNumbers();
            ArrayList<Role> roles = loader.getRole();
            ArrayList<Topic> topics = loader.getTopic();

            connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            for (Topic topic : topics) {
                System.out.println(topic.getTopicID());
            }
            for (Edition edition : editions) {
                System.out.println(edition.getEditionID());
            }
            String text = null;

            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Topic(TopicID, BriefDescription, Title) values(?,?,?)");
                for(Topic topic : topics) {
                    statement.setInt(1, topic.getTopicID());
                    statement.setString(2, topic.getBriefDescription());
                    statement.setString(3, topic.getTitle());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into NewsItem(NewsItemID, TopicID, TimeInEdition, BriefDescription, NumberOfViews) values(?,?,?,?,?)");
                for(NewsItem newsItem : newsItems) {
                    statement.setInt(1, newsItem.getNewsItemID());
                    statement.setInt(2, newsItem.getTopicID());
                    statement.setTime(3, newsItem.getTimeInEdition());
                    statement.setString(4, newsItem.getBriefDescription());
                    statement.setInt(5, newsItem.getNumberOfViews());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Country(country) values(?);");
                for(Country country : countries) {
                    statement.setString(1, country.getCountry());
                    statement.addBatch();

                }statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into City(CityID, Country, ZIPCode) values(?,?,?);");
                for(City city : cities) {
                    statement.setInt(1,city.getCityID());
                    statement.setString(2, city.getCountry());
                    statement.setInt(3,city.getZIPCode());
                    statement.addBatch();

                }statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Address(AddressID, CityID, StreetName, CivicNumber) values(?,?,?,?);");
                for(Address address : addresses) {
                    statement.setInt(1, address.getAddressID());
                    statement.setInt(2, address.getCityID());
                    statement.setString(3, address.getStreetName());
                    statement.setInt(4, address.getCivicNumber());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Journalist(CPR, AddressID, FirstName, LastName) values(?,?,?,?);");
                for(Journalist journalist : journalists) {
                    statement.setInt(1, journalist.getCPR());
                    statement.setInt(2, journalist.getAdressID());
                    statement.setString(3, journalist.getFirstName());
                    statement.setString(4, journalist.getLastName());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Footage(FootageID, CPR, Title, DateOfFootage, Duration) values(?,?,?,?,?);");
                for(Footage footage1 : footage) {
                    statement.setInt(1, footage1.getFootageID());
                    statement.setInt(2, footage1.getCPR());
                    statement.setString(3, footage1.getTitle());
                    statement.setDate(4, footage1.getDate());
                    statement.setTime(5, footage1.getDuration());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Edition(EditionID, CPR, DateOfAir, Length, TimeOfAir) values(?,?,?,?,?);");
                for(Edition edition : editions) {
                    statement.setInt(1, edition.getEditionID());
                    statement.setInt(2, edition.getCPR());
                    statement.setDate(3, edition.getDate());
                    statement.setTime(4, edition.getLength());
                    statement.setTime(5, edition.getTime());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into ConnectedFootage(FootageID, NewsItemID) values(?,?);");
                for(ConnectedFootage connectedFootage : conFootage) {
                    statement.setInt(1, connectedFootage.getFootageID());
                    statement.setInt(2, connectedFootage.getNewsItemID());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Roles(CPR, TopicID, RoleOfJounalist) values(?,?,?);");
                for(Role role : roles) {
                    statement.setInt(1, role.getCPR());
                    statement.setInt(2, role.getTopicID());
                    statement.setString(3, role.getRole());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println();
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into ConnectedNewsitems(EditionID, NewsItemID) values(?,?);");
                for(ConnectedNewsItems connectedNewsItems : conNewsItems) {
                    statement.setInt(1, connectedNewsItems.getEditionID());
                    statement.setInt(2, connectedNewsItems.getNewsItemID());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into PhoneNumbers(CountryCode, PhoneNumber, CPR) values(?,?,?);");
                for(PhoneNumbers phoneNumbers1 : phoneNumbers) {
                    statement.setString(1, phoneNumbers1.getCountryCode());
                    statement.setString(2, phoneNumbers1.getPhoneNumber());
                    statement.setInt(3, phoneNumbers1.getCPR());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                PreparedStatement statement = connection.prepareStatement("Insert into Emails(Email, CPR) values(?,?);");
                for(Emails emails1 : emails) {
                    statement.setString(1, emails1.getEmail());
                    statement.setInt(2, emails1.getCPR());
                    statement.addBatch();
                } statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.commit();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
