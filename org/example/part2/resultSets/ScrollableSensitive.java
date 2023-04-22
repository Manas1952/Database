package org.example.part2.resultSets;

import java.sql.*;

// not supported by H2
public class ScrollableSensitive {
  public static void main(String[] args) throws Exception
  {
//    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    Statement st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet rs=st.executeQuery("select eno from employees");
    System.out.println("Records Before Updation");
    System.out.println("ENO\tENAME\tESAL\tEADDR");
    System.out.println("---------------------------");
    while(rs.next())
    {
//      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
      System.out.println(rs.getInt(1));
    }
    System.out.println("Application is going to pausing state,please update database..");
    System.in.read();
    rs.beforeFirst();
    System.out.println("Records After Updation");
    while(rs.next())

    {
      rs.refreshRow();
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
    }
    con.close();
  }
}
