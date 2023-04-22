package org.example.part2.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IsolationLevel {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");) {

      System.out.println(connection.getTransactionIsolation());

      connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

      System.out.println(connection.getTransactionIsolation());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
