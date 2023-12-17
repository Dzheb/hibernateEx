package one_to_one;

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
           Author author = new Author("Лев Толстой");
            Book book = new Book("Семейное счастие", 1859);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Война и мир", 1865);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Анна Каренина", 1875);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Воскресение", 1889);
            book.setAuthor(author);
            session.save(book);
              author = new Author("Николай Гоголь");
              book = new Book("Женитьба", 1842);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Мёртвые души", 1842);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Игроки", 1842);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Шинель",  1842);
            book.setAuthor(author);
            session.save(book);
            book = new Book("Женитьба", 1842);
            book.setAuthor(author);
            session.save(book);
            author = new Author("Фёдор Достоевский");
            book.setAuthor(author);
            book = new Book("Бедные люди",  1846);
            session.save(book);
            session.getTransaction().commit();
        }
    }

    //        read all records from DB
    private static void selectData(Connector connector) {

        try (Session session = connector.getSession()) {
            session.beginTransaction();
            List<Book> books = session.createQuery("SELECT b FROM Book b " +
                            " ORDER BY year DESC", Book.class)
                    .getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


