package org.example.testing;

public class Gson {
  public static void main(String[] args) {
    String type = "read";
//    String jsonString = "{type: " + type + ", columns: ['col1', 'col2', 'col3'], values: ['val1', 'val2', 'val3']}";
    String jsonString = "{type: 'table', tablesList: [], table: EMPLOYEES, columns: [], values: []}";

    com.google.gson.Gson gson = new com.google.gson.Gson();

    Format format = gson.fromJson(jsonString, Format.class);

    System.out.println(format.type + " " + format.type.getClass());
    System.out.println(format.table + " " + format.columns.getClass());
//    System.out.println(format.values[0] + " " + format.values.getClass());

  }
}
