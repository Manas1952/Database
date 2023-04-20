package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMultipleRows {
  public static void main(String[] args) {
//    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
      Statement statement = connection.createStatement();

      String sqlQuery = String.format("update employees set esal=esal+%f where esal<1000000", 1000000.00);
      int count = statement.executeUpdate(sqlQuery);

      System.out.println("rows updated: " + count);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
