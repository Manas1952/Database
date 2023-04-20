package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInput {
  public static void main(String[] args) {
//    try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Scanner scanner = new Scanner(System.in)) {

      Statement statement = connection.createStatement();

      System.out.println("Enter eno: ");
      int eno = scanner.nextInt();
      System.out.println("Enter ename: ");
      scanner.nextLine();
      String ename = scanner.nextLine();
      System.out.println("Enter esal: ");
      int esal = scanner.nextInt();
      System.out.println("Enter eaddr: ");
      scanner.nextLine();
      String eaddr = scanner.nextLine();

      statement.executeUpdate("insert into employees values(" + eno + ", '\"" + ename + "\"', " + esal + ", '" + eaddr + "')");

      System.out.println("row inserted");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
