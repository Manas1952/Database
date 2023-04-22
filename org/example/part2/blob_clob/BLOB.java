package org.example.part2.blob_clob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class BLOB {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      PreparedStatement preparedStatement = connection.prepareStatement("insert into persons values (?, ?)");

      File file = new File("/home/manas/Pictures/Wallpapers/Batman.jpg");
      FileInputStream fileInputStream = new FileInputStream(file);

      preparedStatement.setString(1, "batman");
      preparedStatement.setBinaryStream(2, fileInputStream);

      int count = preparedStatement.executeUpdate();

      if (count == 1) {
        System.out.println("inserted");
      }
      else {
        System.out.println("Ille");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
