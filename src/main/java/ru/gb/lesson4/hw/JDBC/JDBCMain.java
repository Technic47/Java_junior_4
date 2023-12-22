package ru.gb.lesson4.hw.JDBC;

import ru.gb.lesson4.hw.entities.Book;

import java.sql.SQLException;
import java.util.List;

public class JDBCMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnection dbConnection = new DbConnection();
        Dao dao = new Dao(dbConnection);
        Book book1 = new Book(1, "Test", "Author1");
        Book book2 = new Book(2, "Test", "Author2");
        Book book3 = new Book(3, "Test", "Author3");
        Book book4 = new Book(4, "Test", "Author4");
        Book book5 = new Book(5, "Test", "Author5");
        Book book6 = new Book(6, "Test", "Author1");
        Book book7 = new Book(7, "Test", "Author2");
        Book book8 = new Book(8, "Test", "Author3");
        Book book9 = new Book(9, "Test", "Author4");
        Book book10 = new Book(10, "Test", "Author5");

        dao.createTableBooks();

        dao.save(book1);
        dao.save(book2);
        dao.save(book3);
        dao.save(book4);
        dao.save(book5);
        dao.save(book6);
        dao.save(book7);
        dao.save(book8);
        dao.save(book9);
        dao.save(book10);

        String author = "Author3";
        System.out.println("Books with author = '" + author +"':");
        List<Book> booksByAuthor = dao.getBooksByAuthor(author);
        booksByAuthor.forEach(System.out::println);
    }
}
