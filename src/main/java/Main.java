import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static final String DB_URL
            = "jdbc:mysql://localhost/" +
            "ksiegarnia?useSSL=false&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConnection.getConnection();

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");

            while(resultSet.next()){
                System.out.println(resultSet.getString("title")
                        + " " + resultSet.getString("author")
                        + " "  +  resultSet.getString("published")
                        + " "  +  resultSet.getString("isbn")
                        + " "  +  resultSet.getString("category")
                        + " "  +  resultSet.getString("page_count")
                        + " "  +  resultSet.getString("publisher")
                        + " " +  resultSet.getString("price")
                );


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
