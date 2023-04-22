package org.example.part2.metadata;
import java.sql.*;

class ParameterMetaDataDemo
{
  public static void main(String[] args) throws Exception
  {
    Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
    PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?,?)");
    ParameterMetaData pmd=pst.getParameterMetaData();
    int count=pmd.getParameterCount();
    for(int i=1;i<= count;i++)
    {
      System.out.println("Parameter Number:"+i);
      System.out.println("Parameter Mode:"+pmd.getParameterMode(i));
      System.out.println("Parameter Type:"+pmd.getParameterType(i));
      System.out.println("Parameter Precision:"+pmd.getPrecision(i));
      System.out.println("Parameter Scale:"+pmd.getScale(i));
      System.out.println("Parameter isSigned:"+pmd.isSigned(i));
      System.out.println("Parameter isNullable:"+pmd.isNullable(i));
      System.out.println("---------------");
    }
    con.close();
  }
}
