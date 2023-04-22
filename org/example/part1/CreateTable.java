package org.example.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("create table dummy1(id int not null auto_increment, name varchar2(10), balance number(10,2), primary key (id))");

      System.out.println("Table created");

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
