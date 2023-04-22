package org.example.part2.resultSets;

import java.sql.*;
public class ScrollableInsensitive
{
  public static void main(String[] args) throws Exception
  {
    Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
    Statement st =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet rs=st.executeQuery("select * from employees");
    System.out.println("Records in Forward Direction");
    System.out.println("ENO\tENAME\tESAL\tEADDR");
    System.out.println("---------------------------");
    while(rs.next())
    {
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
    }
    System.out.println("Records in Backword Direction");
    System.out.println("ENO\tENAME\tESAL\tEADDR");
    System.out.println("---------------------------");
    while(rs.previous())
    {
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
    }
    con.close();
  }
}
