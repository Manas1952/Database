package org.example.part2.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insert {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" ,"sa", "")) {
      java.sql.PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values(?, ?, ?, ?)");

      preparedStatement.setInt(1, 7);
      preparedStatement.setString(2, "Mihir");
      preparedStatement.setInt(3, 1000000);
      preparedStatement.setString(4, "addr");

      preparedStatement.executeUpdate();

      System.out.println("row inserted");
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
