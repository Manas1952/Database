package org.example.task;

import java.sql.*;

public class EmployeeDAO {
  public Employee getEmployee(int eno) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from employees where eno = " + eno);

      resultSet.next();

      Employee employee = new Employee();

      employee.setEno(resultSet.getInt(1));
      employee.setEname(resultSet.getString(2));
      employee.setEsal(resultSet.getInt(3));
      employee.setEaddr(resultSet.getString(4));

      return employee;
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
