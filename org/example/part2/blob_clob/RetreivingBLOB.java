package org.example.part2.blob_clob;

import java.io.*;
import java.sql.*;

public class RetreivingBLOB {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

      PreparedStatement preparedStatement = connection.prepareStatement("select * from persons");

      ResultSet resultSet = preparedStatement.executeQuery();

      FileOutputStream fileOutputStream = new FileOutputStream("/home/manas/Pictures/Wallpapers/Batman_new.jpg");

      if (resultSet.next()) {
        String name = resultSet.getString(1);
        InputStream inputStream = resultSet.getBinaryStream(2);

        byte[] buffer = new byte[2048];

        while (inputStream.read(buffer) > 0) {
          fileOutputStream.write(buffer);
        }

        fileOutputStream.flush();

        System.out.println("done");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
