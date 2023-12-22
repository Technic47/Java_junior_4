package ru.gb.lesson4.hw.JDBC;

import ru.gb.lesson4.hw.entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private DbConnection dbConnection;

    public Dao(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void createTableBooks() {
        String sql = "create table if not exists " +
                "books (" +
                "id bigint," +
                "name varchar(255)," +
                "author varchar(255));";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        String sql = "insert into books values (?1,?2,?3)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, book.getId());
            statement.setString(2, book.getName());
            statement.setString(3, book.getAuthor());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from books where author = '" + author + "'";
        return getBooks(bookList, sql);
    }

    private List<Book> getBooks(List<Book> bookList, String sql) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                bookList.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
