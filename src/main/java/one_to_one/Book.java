package one_to_one;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    public Book() {

    }

    public Book (String name,  int year) {
        this.name = name;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author")
    private Author author_detail;

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

    public Author getAuthor() {
        return author_detail;
    }

    public void setAuthor(Author author) {
        this.author_detail = author;
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
                ", author='" + author_detail + '\'' +
                ", year=" + year +
                '}';
    }
}

