package org.example.part2.sqlInjection;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsingPreparedStatement {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" ,"sa", "")) {

      java.sql.PreparedStatement preparedStatement = connection.prepareStatement("select * from users where uname=? and upass=?");

      preparedStatement.setString(1, "manas");
      preparedStatement.setString(2, "password1");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
      }
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

  // CREATE ALIAS NEXT_PRIME AS ' String nextPrime(String value) { return new BigInteger(value).nextProbablePrime().toString();}';

  // CREATE ALIAS NEXT_PRIME AS ' String nextPrime(String value) { return new BigInteger(value).nextProbablePrime().toString();}';

// call NEXT_PRIME('1234')