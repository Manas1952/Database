package org.example.part2.connectionPool;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {
  public static void main(String[] args) {
    JdbcDataSource dataSource = new JdbcDataSource();

    dataSource.setURL("jdbc:h2:tcp://localhost/~/test");
    dataSource.setUser("sa");
    dataSource.setPassword("");
    try {
      Connection connection = dataSource.getConnection();

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from employees");

      while (resultSet.next()) {
        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getFloat(3)+"\t"+resultSet.getString(4));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
