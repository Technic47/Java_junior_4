package ru.gb.lesson4.hw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jpa_books")
public class JpaBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    private Author author;

    public JpaBook(String name) {
        this.name = name;
    }

    public JpaBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JpaBook)) return false;
        JpaBook jpaBook = (JpaBook) o;
        return id == jpaBook.id && Objects.equals(name, jpaBook.name) && Objects.equals(author, jpaBook.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author);
    }

    @Override
    public String toString() {
        return "JpaBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author.getName() +
                '}';
    }
}
