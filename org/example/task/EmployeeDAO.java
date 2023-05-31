package org.example.task;

import java.sql.*;

public class EmployeeDAO {
  public String[] getTables(Connection connection) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("select table_name from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = 'PUBLIC'");
    ResultSet resultSet = statement.executeQuery();

    String[] tables = new String[10];
    int iterator = 0;
    String tableName;

    System.out.println("----- Tables -----");
    while (resultSet.next()) {
      tableName = resultSet.getString(1);
      System.out.println((iterator+1) + ". " + tableName);
      tables[iterator] = tableName;
      iterator++;
    }

    return tables;
  }
  public void execute(String sqlQuery, Connection connection) {
    try {
      Statement statement = connection.createStatement();

      boolean isSelectQuery = statement.execute(sqlQuery);
      if (isSelectQuery) {
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
          for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            System.out.print(resultSet.getObject(i+1) + " ");
          }
          System.out.println();
        }
      }
      else {
        int affectedRows = statement.getUpdateCount();
        System.out.println("Affected rows: " + affectedRows);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
