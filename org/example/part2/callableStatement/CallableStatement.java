package org.example.part2.callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatement {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" ,"sa", "")) {

      java.sql.CallableStatement callableStatement = connection.prepareCall("{call NEXT_PRIME(?)}");

      callableStatement.setInt(1, 1234);
//      callableStatement.setString(2, "password1");

//      ResultSet resultSet = callableStatement.executeQuery();
      ResultSet resultSet = callableStatement.executeQuery();

      while (resultSet.next()) {
        System.out.println(resultSet.getString(1));
      }
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
