import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestJDBC {
    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@10.28.43.13:1521:MSKDEV3";
        String user = "sa";
        String passwd = "sa";
        return DriverManager.getConnection(url, user, passwd);
    }

    private static Connection connection;

    @Before
    public void init() throws SQLException {
        connection = getNewConnection();
    }

    @After
    public void close() throws SQLException {
        connection.close();
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try (Connection connection = getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }


    @Test
    public void TestStatement() throws SQLException {
        String query = "SELECT * FROM table_case WHERE OBJID='23970958'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            String name = resultSet.getString("title");
            System.out.println(name);
        }
    }

    @Test
    public void TestSelect() throws SQLException {
        String query = "SELECT * FROM table_case ";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("title");
            System.out.println(name);
        }
    }

    @Test
    public void testPreparedStatement() throws SQLException {
        String query = "SELECT * FROM table_case WHERE objid > ? and objid < ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, 23970958);
        statement.setInt(2, 23970960);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("title");
            System.out.println(name);
        }
    }

}
