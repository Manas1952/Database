package org.example.part2.excel;

import org.h2.tools.Csv;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Reading {
  public static void main(String[] args) {
    try  {
      ResultSet resultSet = new Csv().read("/home/manas/Downloads/ifTable.7126.csv", null, null);

      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

      while (resultSet.next()) {
        for (int iterator = 0; iterator < resultSetMetaData.getColumnCount(); iterator++) {
          System.out.println(resultSetMetaData.getColumnLabel(iterator+1) + ": " + resultSet.getString(iterator+1));
        }
        System.out.println("--------------------------");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
