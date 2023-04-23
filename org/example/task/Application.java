package org.example.task;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {

      EmployeeDAO employeeDAO = new EmployeeDAO();

      String option = "y";
      int choice;

      while (option.equals("y")) {
        System.out.print("----- Menu -----\n1.Read\n2.Insert\n3.Update\n4.Delete\nEnter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
          case 1:
            System.out.print("Enter Employee ID: ");

            int eno = scanner.nextInt();

            Employee employee = employeeDAO.getEmployee(eno);

            System.out.println("\n" + employee.toString() + "\n");

            break;
        }

        System.out.print("Wanna continue[Enter 'y' to continue]: ");
        scanner.nextLine();
        option = scanner.nextLine();
      }


    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
}
