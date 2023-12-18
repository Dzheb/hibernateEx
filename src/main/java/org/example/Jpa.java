package org.example;

//* 2. С помощью JPA(Hibernate) выполнить:
//        * 2.1 Описать сущность Book из пункта 1.1
//        * 2.2 Создать Session и сохранить в таблицу 10 книг
//        * 2.3 Выгрузить список книг какого-то автора
//* 3.* Создать сущность Автор (id biging, name varchar),
// и в сущности Book сделать поле типа Author (OneToOne)
//        * 3.1 * Выгрузить Список книг и убедиться,
//        что поле author заполнено
//        * 3.2 ** В классе Author создать поле List<Book>,
//        которое описывает список всех книг этого автора. (OneToMany)

import org.hibernate.Session;

import java.util.List;

public class Jpa {

    public static void main(String[] args) {

        Connector connector = new Connector();
//   insertData(connector);
        selectData(connector);
    }

    //    insert new records
    private static void insertData(Connector connector) {
        try (Session session = connector.getSession()) {
            session.beginTransaction();
            Book book = new Book("Семейное счастие", "Лев Толстой", 1859);
            session.save(book);
            book = new Book("Война и мир", "Лев Толстой", 1865);
            session.save(book);
            book = new Book("Анна Каренина", "Лев Толстой", 1875);
            session.save(book);
            book = new Book("Воскресение", "Лев Толстой", 1889);
            session.save(book);
            book = new Book("Женитьба", "Николай Гоголь", 1842);
            session.save(book);
            book = new Book("Мёртвые души", "Николай Гоголь", 1842);
            session.save(book);
            book = new Book("Игроки", "Николай Гоголь", 1842);
            session.save(book);
            book = new Book("Шинель", "Николай Гоголь", 1842);
            session.save(book);
            book = new Book("Женитьба", "Николай Гоголь", 1842);
            session.save(book);
            book = new Book("Бедные люди", "Фёдор Достоевский", 1846);
            session.save(book);
            session.getTransaction().commit();
        }
    }

    //        read all records from DB
    private static void selectData(Connector connector) {

        try (Session session = connector.getSession()) {
            session.beginTransaction();
            List<Book> books = session.createQuery("SELECT b FROM Book b WHERE author = 'Лев Толстой'" +
                            " ORDER BY year DESC", Book.class)
                    .getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


