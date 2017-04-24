import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by RENT on 2017-04-24.
 */
public class DBConnection {

    public static DBConnection instance;
    public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "";

    public DBConnection() {
        try {
            Class.forName(JBDC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
            System.out.println(" Connection  - - - - - - - -  New DBConnection created" );
        }
        try {
            return DriverManager.getConnection(instance.DB_URL, instance.USER,instance.PASSWORD);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void close(Connection connection)
    {
        try {
            if (connection != null) {
                connection.close();
                connection=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
