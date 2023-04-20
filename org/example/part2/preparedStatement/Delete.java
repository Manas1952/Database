package org.example.part2.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Delete {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" ,"sa", "")) {
      java.sql.PreparedStatement preparedStatement = connection.prepareStatement("delete from employees where ename = ?");

      preparedStatement.setString(1, "Mihir");

      preparedStatement.executeUpdate();

      System.out.println("row deleted");
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
