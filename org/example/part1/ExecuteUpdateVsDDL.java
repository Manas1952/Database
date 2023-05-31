package org.example.part1;

import java.sql.*;

public class ExecuteUpdateVsDDL {
  public static void main(String[] args) {

//    Class.forName("org.h2.Driver");

    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      if (connection != null) {
        System.out.println("connected");
//        System.out.println(connection.getClass().getName());
      } else {
        System.out.println("not connected");
      }

      Statement statement = connection.createStatement();
      Boolean x = statement.execute("drop table employees1;");
      System.out.println(x);

//      while (resultSet.next()) {
//        System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
//      }
    }
    catch (SQLException e) {
      System.out.println("Exception: " + e);
    }
  }
}

// CREATE TABLE  persons (id INTEGER not NULL, first VARCHAR(255), last VARCHAR(255), age INTEGER, PRIMARY KEY ( id ))
//    "INSERT INTO persons VALUES (103, 'Manas', 'Purohit', 21);"
// select * from persons;
