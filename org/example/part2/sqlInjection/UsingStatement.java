package org.example.part2.sqlInjection;

import java.sql.*;
import java.util.Scanner;

public class UsingStatement {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Scanner scanner = new Scanner(System.in)) {

      System.out.println("Enter username: ");
      String uname = scanner.nextLine(); // here enter '--

      System.out.println("Enter password: ");
      String upass = scanner.nextLine();

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from users where uname='" + uname + "' and upass = '" + upass + "'");

      while (resultSet.next()) {
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

// select * from users where uname='manas'--' and upass = 'password1'";