package org.example.part2.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Savepoint {
  public static void main(String[] args)
 {
    try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");) {

      Statement st = con.createStatement();

      con.setAutoCommit(false);

      st.executeUpdate("insert into accounts values ('qwer',1234)");
      st.executeUpdate("insert into accounts values ('asdf',2345)");

      java.sql.Savepoint sp = con.setSavepoint();

      st.executeUpdate("insert into accounts values ('zxcv',3456)");

      System.out.println("oops ..wrong entry just rollback");
      con.rollback(sp);

      con.releaseSavepoint(sp);
      //System.out.println("Operations are roll back from Savepoint");
      con.commit();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

 }
}
