import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class TV3InfoReader {
    ArrayList<Address> address = new ArrayList<>();
    ArrayList<City> city = new ArrayList<>();
    ArrayList<ConnectedFootage> connectedFootage = new ArrayList<>();
    ArrayList<ConnectedNewsItems> connectedNewsItems = new ArrayList<>();
    ArrayList<Country> country = new ArrayList<>();
    ArrayList<Edition> edition = new ArrayList<>();
    ArrayList<Emails> emails = new ArrayList<>();
    ArrayList<Footage> footage = new ArrayList<>();
    ArrayList<Journalist> journalist = new ArrayList<>();
    ArrayList<NewsItem> newsItem = new ArrayList<>();
    ArrayList<PhoneNumbers> phoneNumbers = new ArrayList<>();
    ArrayList<Role> role = new ArrayList<>();
    ArrayList<Topic> topic = new ArrayList<>();

    public Time getTime(String time) throws ParseException {
        return java.sql.Time.valueOf(time);
    }
    public Date getDate(String date) {
        return java.sql.Date.valueOf(date);
    }

    public void readFile(String filename) throws ParseException {

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null){
                tempArr = line.split(",",-1);
                switch (tempArr[0]) {
                    case "Topic":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            topic.add(new Topic(parseInt(tempArr[0]), tempArr[1], tempArr[2], "Topic"));
                            System.out.println(0);
                        } break;

                    case "NewsItem":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            newsItem.add(new NewsItem(parseInt(tempArr[0]), parseInt(tempArr[1]), this.getTime(tempArr[2]), tempArr[3], parseInt(tempArr[4]), "NewsItem"));
                        } System.out.println(1);
                        break;
                    case "Country":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            country.add(new Country(tempArr[0], "Country"));
                        } System.out.println(2);
                        break;
                    case "City":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            city.add(new City(parseInt(tempArr[0]), tempArr[1], parseInt(tempArr[2]), "City"));
                        } System.out.println(3);
                        break;
                    case "Journalist":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            journalist.add(new Journalist(parseInt(tempArr[0]), parseInt(tempArr[1]), tempArr[2], tempArr[3], "Journalist"));
                        } System.out.println(4);
                        break;
                    case "Address":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            address.add(new Address(parseInt(tempArr[0]), parseInt(tempArr[1]), tempArr[2], parseInt(tempArr[3]), "Address"));
                        } System.out.println(5);
                        break;
                    case "Footage":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            footage.add(new Footage(parseInt(tempArr[0]), parseInt(tempArr[1]), tempArr[2], this.getDate(tempArr[3]), this.getTime(tempArr[4]), "Footage"));
                        }
                        break;
                    case "Editions":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            System.out.println(tempArr[0]);
                            edition.add(new Edition(parseInt(tempArr[0]), parseInt(tempArr[1]), getDate(tempArr[2]), getTime(tempArr[3]), getTime(tempArr[4]),"Edition"));
                        } System.out.println(7);
                        break;
                    case "ConnectedFootage":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            connectedFootage.add(new ConnectedFootage(parseInt(tempArr[0]), parseInt(tempArr[1]), "ConnectedFootage"));
                        } System.out.println(8);
                        break;
                    case "Roles":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            role.add(new Role(parseInt(tempArr[0]), parseInt(tempArr[1]), tempArr[2], "Roles"));
                        } System.out.println(8);
                        break;
                    case "ConnectedNewsitems":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            connectedNewsItems.add(new ConnectedNewsItems(parseInt(tempArr[0]), parseInt(tempArr[1]), "ConnectedNewsitems"));
                        } System.out.println(9);
                        break;
                    case "PhoneNumbers":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            phoneNumbers.add(new PhoneNumbers(tempArr[0], tempArr[1], parseInt(tempArr[2]), "PhoneNumbers"));
                        } System.out.println(10);
                        break;
                    case "Emails":
                        while(!(line = br.readLine()).equals("break,,,,")) {
                            tempArr = line.split(",",-1);
                            emails.add(new Emails(tempArr[0], parseInt(tempArr[1]), "Emails"));
                        } System.out.println(11);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public TV3InfoReader() {};

    //For testing
    public static void main(String[] args) throws ParseException {
        TV3InfoReader temp = new TV3InfoReader();

        temp.readFile("C:\\Users\\jonat\\OneDrive\\Skrivebord\\2. semester\\Mock data - Ark1.csv");

    }

    public ArrayList<Address> getAddress() { return address; }

    public ArrayList<City> getCity() {
        return city;
    }

    public ArrayList<ConnectedFootage> getConnectedFootage() { return connectedFootage; }

    public ArrayList<ConnectedNewsItems> getConnectedNewsItems() {
        return connectedNewsItems;
    }

    public ArrayList<Country> getCountry() {
        return country;
    }

    public ArrayList<Edition> getEdition() {
        return edition;
    }

    public ArrayList<Emails> getEmails() {
        return emails;
    }

    public ArrayList<Footage> getFootage() {
        return footage;
    }

    public ArrayList<Journalist> getJournalist() {
        return journalist;
    }

    public ArrayList<NewsItem> getNewsItem() {
        return newsItem;
    }

    public ArrayList<PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<Role> getRole() {
        return role;
    }

    public ArrayList<Topic> getTopic() {
        return topic;
    }
}
