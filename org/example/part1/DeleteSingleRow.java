package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteSingleRow {
  public static void main(String[] args) {
//    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Scanner scanner = new Scanner(System.in)) {
      Statement statement = connection.createStatement();

      System.out.println("Enter ename to delete: ");
      int eno = scanner.nextInt();
      String sqlQuery = String.format("delete from employees where eno='%d'", eno);
      int count = statement.executeUpdate(sqlQuery);

      System.out.println("rows deleted: " + count);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
