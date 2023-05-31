package org.example.task;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

public class Application {
  public static void main(String[] args) {

    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("/home/manas/Manas/Database/src/main/resources/db.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    String url = properties.getProperty("url");
    String user = properties.getProperty("user");
    String pswd = properties.getProperty("pswd");

    try (Connection connection = DriverManager.getConnection(url, user, pswd); BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {

      EmployeeDAO employeeDAO = new EmployeeDAO();

      String option = "y";
      int choice;
      int tableNo;
      String tableName;

      while (option.equals("y")) {
        System.out.print("\n----- Menu -----\n1.Read\n2.Insert\n3.Update\n4.Delete\nEnter your choice: ");
        choice = Integer.parseInt(scanner.readLine());

        String[] tables = employeeDAO.getTables(connection);

        System.out.print("\nEnter table number: ");

        tableNo = Integer.parseInt(scanner.readLine());
        tableName = tables[tableNo-1];

        ResultSet resultSet = connection.getMetaData().getColumns(null, null, tableName, null);

        HashMap<String, String> hashMap = new HashMap();
        LinkedList columnTypes = new LinkedList();

        System.out.println("\n----- Columns -----");
        String columnName, columnType;
        int columnCount = 0;
        while (resultSet.next()) {
          columnName = resultSet.getString("COLUMN_NAME");
          columnType = resultSet.getString("TYPE_NAME");
          hashMap.put(String.valueOf(columnCount+1), columnName);
          columnTypes.add(columnType);
          columnCount++;
          System.out.println(columnCount + ". "+columnName);
        }

//        System.out.println(hashMap);
        String sqlQuery;

          switch (choice) {
            case 1:

              System.out.print("\nEnter column names delimited by comma(,): ");
              String columns = scanner.readLine();

              System.out.print("\nWanna enter WHERE clause? [y/n]: ");
              String isWhereClause = scanner.readLine();
              if (columns.equals("*")) {
                sqlQuery = "select * from " + tableName ;
              }
              else {
                String intColumns[] = columns.split(",");
                sqlQuery = "select ";
                for (int i = 0; i < intColumns.length; i++) {
                  sqlQuery += hashMap.get(String.valueOf(i+1)) + ",";
                }
                sqlQuery = sqlQuery.substring(0, sqlQuery.length()-1);
                sqlQuery += " from " + tableName;
              }

              if (isWhereClause.equals("y")) {
                System.out.print("Enter WHERE clause: ");
                String whereClause = scanner.readLine();
                sqlQuery += " where " + whereClause;
              }
              System.out.println("-> " + sqlQuery);

              employeeDAO.execute(sqlQuery, connection);

              break;

            case 2:
              String stringValue;
              int intValue;
              sqlQuery = "insert into " + tableName + " values (";

              for (int i = 0; i < columnCount; i++) {
                System.out.println("Enter " + hashMap.get(String.valueOf(i+1)));

                if (columnTypes.get(i).equals("CHARACTER VARYING")) {
                  System.out.println("stringValue");
                  stringValue = scanner.readLine();
                  sqlQuery += "'" + stringValue + "', ";
                }
                else {
                  System.out.println("intValue");
                  intValue = Integer.parseInt(scanner.readLine());
                  sqlQuery += intValue + ", ";
                }
              }
              sqlQuery = sqlQuery.substring(0, sqlQuery.length()-2);
              sqlQuery += ")";

              System.out.println(sqlQuery);

              employeeDAO.execute(sqlQuery, connection);
              break;

            case 3:

              System.out.print("Enter " + hashMap.get("1") + ": ");
              int eno = Integer.parseInt(scanner.readLine());

              System.out.print("Enter columns to update: ");
              String columnsToUpdate = scanner.readLine();
              String column[] = columnsToUpdate.split(",");

              sqlQuery = "update " + tableName + " set ";

              for (int i = 0; i < column.length; i++) {
                if (columnTypes.get(Integer.parseInt(column[i])-1).equals("CHARACTER VARYING")) {
                  System.out.println("- " + hashMap.get(column[i] + " " + columnTypes.get(Integer.parseInt(column[i])-1)));
                  sqlQuery += hashMap.get(column[i]) + " = '" + scanner.readLine() + "', ";
                }
                else {
                  System.out.println("-- " + hashMap.get(column[i]) + " " + columnTypes.get(Integer.parseInt(column[i])-1));
                  sqlQuery += hashMap.get(column[i]) + " = " + Integer.parseInt(scanner.readLine()) + ", ";
                }
              }
              sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2) + " where " + hashMap.get("1") + " = " + eno;

              System.out.println(sqlQuery);

              employeeDAO.execute(sqlQuery, connection);
              break;

            case 4:

              System.out.print("Enter employee id to delete: ");
              int enoToDelete = Integer.parseInt(scanner.readLine());

              sqlQuery = "delete from " + tableName + " where eno = " + enoToDelete;

              System.out.println(sqlQuery);



              break;
          }

          System.out.print("Wanna continue[Enter 'y' to continue]: ");
          option = scanner.readLine();
      }
    } catch (SQLException | IOException exception) {
      System.out.println("->"+exception);
    }
  }

}
