package org.example.part2.batchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      java.sql.PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values(?,?,?,?)");

      preparedStatement.setInt(1, 6);
      preparedStatement.setString(2, "name");
      preparedStatement.setDouble(3, 9876.00);
      preparedStatement.setString(4, "addr");

      preparedStatement.addBatch();

      int counts[] = preparedStatement.executeBatch();

      for (int count : counts) {
        System.out.println("count: " + count);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
