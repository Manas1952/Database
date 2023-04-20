package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("drop table employees1");

      System.out.println("Table dropped");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
