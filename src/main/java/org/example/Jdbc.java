package org.example;

import java.sql.*;
//* 1. С помощью JDBC выполнить:
//        * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
//        * 1.2 Добавить в таблицу 10 книг
//        * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
//        *
public class Jdbc {
  public static void main(String[] args) throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testGB","root","root");
    prepareTables(connection);
    insertData(connection);
    executeSelect(connection);
    connection.close();
  }
  private static void executeSelect(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      ResultSet resultSet = statement.executeQuery("select * from books where author = 'Николай Гоголь'");
      int counter = 0;
      while (resultSet.next()) {
        String name = resultSet.getString("name");
       int year = resultSet.getInt("year");
        String author = resultSet.getString("author");
        System.out.println("[" + counter++ + "] книга: \"" + name + "\", автор: \"" + author
                + "\", год издания: " + year);
      }
    }
  }

  private static void prepareTables(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute("""
        create table books (
        id bigint,
        name varchar(255),
        author varchar(255),
        year int
        )
        """);
    }
  }

  private static void insertData(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      int updatedRows = statement.executeUpdate("""
              insert into books(id, name,author,year) 
              values
              (1, 'Семейное счастие', 'Лев Толстой',1859),
              (2, 'Война и мир', 'Лев Толстой',1865),
              (3, 'Анна Каренина', 'Лев Толстой',1875),
              (4, 'Воскресение', 'Лев Толстой',1889),
              (5, 'Женитьба', 'Николай Гоголь',1842),
              (6, 'Мёртвые души', 'Николай Гоголь',1842),
              (7, 'Игроки', 'Николай Гоголь',1842),
              (8, 'Шинель', 'Николай Гоголь',1842),
              (9, 'Женитьба', 'Николай Гоголь',1842),
              (10,'Бедные люди', 'Фёдор Достоевский',1846)
         """);
      System.out.println(updatedRows);
    }
  }

}
