import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class BaseTest {
    @Getter
    private static Connection connection;
    private static LocalDate today = LocalDate.now();

    private static String formattedDate = today.toString();

    @BeforeAll
    static void init() throws SQLException {
        connect("geekbrainsProject.db");
        createTable("CREATE TABLE IF NOT EXISTS test_info\n" +
                "(id text PRIMARY KEY,\n" +
                "date text NOT NULL,\n" +
                "status text NOT NULL,\n" +
                "description text NOT NULL);");
    }

    private static void connect(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + name);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private static void createTable(String sql) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
        System.out.println("Closed database successfully");
    }

    public static void insertInfo(String status, String description) {
        String sql = "INSERT INTO test_info(" +
                "id,date, status,description) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = BaseTest.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, formattedDate);
            preparedStatement.setString(3, status);
            preparedStatement.setString(4, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
