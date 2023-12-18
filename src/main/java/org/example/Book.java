package org.example;

import javax.persistence.*;
//
// * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
// *
// * 1. С помощью JDBC выполнить:
// * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
// * 1.2 Добавить в таблицу 10 книг
// * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
// *
// * 2. С помощью JPA(Hibernate) выполнить:
// * 2.1 Описать сущность Book из пункта 1.1
// * 2.2 Создать Session и сохранить в таблицу 10 книг
// * 2.3 Выгрузить список книг какого-то автора
// *
@Entity
@Table(name = "book")
public class Book {

    public Book() {

    }

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private int year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}


