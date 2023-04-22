package org.example.part2.metadata;

import java.sql.*;

public class DatabaseMetadata {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");) {

      DatabaseMetaData databaseMetaData = connection.getMetaData();

      System.out.println(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
      System.out.println(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));

      System.out.println(databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
      System.out.println(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
      System.out.println(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

//      ResultSet resultSet = databaseMetaData.getTables(null, null, null, null);
//
//      while (resultSet.next()) {
//        System.out.println(resultSet.getString(3));
//      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
