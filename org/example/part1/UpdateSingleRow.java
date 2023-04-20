package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSingleRow {
  public static void main(String[] args) {
//    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("update employees set ename='Aryan', eaddr='address' where eno=3");

      System.out.println("row updated");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
