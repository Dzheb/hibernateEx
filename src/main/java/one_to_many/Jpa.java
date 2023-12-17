package one_to_many;

//        * 3.2 ** В классе Author создать поле List<Book>,
//        которое описывает список всех книг этого автора. (OneToMany)

import org.hibernate.Session;

import java.util.List;

public class Jpa {

    public static void main(String[] args) {

        Connector connector = new Connector();
        selectData(connector);
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


