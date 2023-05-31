package org.example.part2.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" ,"sa", "")) {
      java.sql.PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values(?, ?, ?, ?)");

      preparedStatement.setInt(1, 12);
      preparedStatement.setString(2, "Jheel");
      preparedStatement.setInt(3, 1000000);
      preparedStatement.setString(4, "amdavad");

      preparedStatement.executeUpdate();

      System.out.println("row inserted");

      ResultSet resultSet = preparedStatement.getResultSet();

      while (resultSet.next()) {
        System.out.println(resultSet.getObject(2));
      }
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
