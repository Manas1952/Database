package org.example.part1;

import java.sql.*;
import java.util.Scanner;

public class NthHighestSalary {
  public static void main(String[] args) {

    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Scanner scanner = new Scanner(System.in)) {

      if (connection != null) {
        System.out.println("connected");
      } else {
        System.out.println("not connected");
      }

      Statement statement = connection.createStatement();

//      String sqlQuery = "select count(*) from employees";
//      String sqlQuery = "select * from employees where esal = (select max(esal) from employees)";
      String sqlQuery = "select * from (select eno, ename, esal, eaddr, rank() over (order by esal desc) myRank from employees) where myRank=2";
      ResultSet resultSet = statement.executeQuery(sqlQuery);

      while (resultSet.next()) {
        System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
      }
    }
    catch (SQLException e) {
      System.out.println("Exception: " + e);
    }
  }
}

// CREATE TABLE  persons (id INTEGER not NULL, first VARCHAR(255), last VARCHAR(255), age INTEGER, PRIMARY KEY ( id ))
//    "INSERT INTO persons VALUES (103, 'Manas', 'Purohit', 21);"
// select * from persons;
