package org.example.part2.batchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingStatement {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      Statement statement = connection.createStatement();

      statement.addBatch("insert into employees values (9, 'qwer', 1234, 'qwer')");
      statement.addBatch("update employees set esal=2345 where eno=9");
      statement.addBatch("update employees set esal=2345 where eno=");
      statement.addBatch("delete from employees where eno=8");

      int counts[] = statement.executeBatch();

      for (int count : counts) {
        System.out.println("count: " + count);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
