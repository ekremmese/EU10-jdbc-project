package jdbc_tests;

import java.sql.*;
import java.util.Arrays;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        //Database connection stream , url, username and password is called
        String dbUrl = "jdbc:oracle:thin:@54.87.214.234:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        // Helps our java project connect to database
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        //Helps to write and execute SQL query
        Statement statement = connection.createStatement();

        //A DataStructure where we can store the data that came from database
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

/*
        System.out.println("------------------------------------------");

        for (int i = 1; i < 5; i++) {
            resultSet.next();
            System.out.println(resultSet.getString(i));
            System.out.println(resultSet.getString(i+1));
        }

 */

        while (resultSet.next()){
            //resultSet.next();
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }

/*
        //next() --> move pointer to the first roq
        resultSet.next();

        //getting info with the column name
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

 */

        //getting info with the column name , indexes start from 1
        //System.out.println(resultSet.getString(2));

        System.out.println("------------------------------------------");

        //next() --> move pointer to the first roq
        //resultSet.next();

        //getting info with the column name , indexes start from 1
        //System.out.println(resultSet.getString(2));


        //close connection, it will be on reversed order
        resultSet.close();
        statement.close();
        connection.close();


    }

}
