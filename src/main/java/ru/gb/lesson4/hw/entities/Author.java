package ru.gb.lesson4.hw.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany
    private Set<JpaBook> books = new HashSet<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
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

    public Set<JpaBook> getBooks() {
        return books;
    }

    public void setBooks(Set<JpaBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Author{")
                .append("id=").append(id)
                .append(", name='").append(name)
                .append(", books: ");
        books.forEach(b -> builder.append("\n")
                .append("Id: ")
                .append(b.getId())
                .append(", name: ")
                .append(b.getName()));
        builder.append("}");
        return builder.toString();

    }
}
