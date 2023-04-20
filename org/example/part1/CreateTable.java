package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("create table employees1(eno number, ename varchar2(10), esal number(10, 2), eaddr varchar2(10))");

      System.out.println("Table created");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
