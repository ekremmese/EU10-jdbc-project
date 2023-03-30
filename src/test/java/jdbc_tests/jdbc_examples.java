package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {

    @Test
    public void test1() throws SQLException {

        //database connections stream: url, username, password
        String dbUrl = "jdbc:oracle:thin:@54.87.214.234:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";


        Connection connection = DriverManager.getConnection(dbUrl, dbPassword, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        //move to the first row
        resultSet.next();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getInt(3) + " - " + resultSet.getInt(4));
        }


        //close connection:
        resultSet.close();
        statement.close();
        connection.close();

    }

}
