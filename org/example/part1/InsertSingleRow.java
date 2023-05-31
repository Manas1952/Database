package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleRow {
  public static void main(String[] args) {
//    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("insert into dummy(name, balance) values('Param', 1000000)");

      System.out.println("row inserted");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
