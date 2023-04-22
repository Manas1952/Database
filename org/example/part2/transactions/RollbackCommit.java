package org.example.part2.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RollbackCommit {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); Scanner scanner = new Scanner(System.in);) {

      connection.setAutoCommit(false);

      Statement statement = connection.createStatement();

      System.out.println("Transaction begins...");
      statement.executeUpdate("update accounts set balance=balance-10000 where name='Manas'");

      System.out.println("Wanna commit transaction[y/n]: ");

      String option = scanner.nextLine();

      if (option.equals("y")) {
        connection.commit();
        System.out.println("Commited!");
      }
      else {
        connection.rollback();
        System.out.println("Rolled back!");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
