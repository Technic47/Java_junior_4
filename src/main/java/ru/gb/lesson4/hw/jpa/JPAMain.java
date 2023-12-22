package ru.gb.lesson4.hw.jpa;

import ru.gb.lesson4.hw.entities.Author;
import ru.gb.lesson4.hw.entities.Book;
import ru.gb.lesson4.hw.entities.JpaBook;

import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerProvider provider = new EntityManagerProvider();
        JpaDao dao = new JpaDao(provider);
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

        Author author1 = new Author("Author1");
        Author author2 = new Author("Author2");
        JpaBook jpaBook1 = new JpaBook("Test1");
        JpaBook jpaBook2 = new JpaBook("Test2");
        JpaBook jpaBook3 = new JpaBook("Test3");
        JpaBook jpaBook4 = new JpaBook("Test4");
        JpaBook jpaBook5 = new JpaBook("Test5");
        JpaBook jpaBook6 = new JpaBook("Test6");
        JpaBook jpaBook7 = new JpaBook("Test7");
        JpaBook jpaBook8 = new JpaBook("Test8");
        JpaBook jpaBook9 = new JpaBook("Test9");
        JpaBook jpaBook10 = new JpaBook("Test10");

        dao.saveBook(book1);
        dao.saveBook(book2);
        dao.saveBook(book3);
        dao.saveBook(book4);
        dao.saveBook(book5);
        dao.saveBook(book6);
        dao.saveBook(book7);
        dao.saveBook(book8);
        dao.saveBook(book9);
        dao.saveBook(book10);

        dao.saveAuthor(author1);
        dao.saveAuthor(author2);

        dao.saveJpaBook(jpaBook1, author1);
        dao.saveJpaBook(jpaBook2, author2);
        dao.saveJpaBook(jpaBook3, author1);
        dao.saveJpaBook(jpaBook4, author2);
        dao.saveJpaBook(jpaBook5, author1);
        dao.saveJpaBook(jpaBook6, author2);
        dao.saveJpaBook(jpaBook7, author1);
        dao.saveJpaBook(jpaBook8, author2);
        dao.saveJpaBook(jpaBook9, author1);
        dao.saveJpaBook(jpaBook10, author2);

        String author = "Author1";
        List<Book> bookList = dao.findBookByAuthor(author);
        System.out.println("Books with author = '" + author + "':");
        bookList.forEach(System.out::println);

        System.out.println(dao.getJpaBookById(1));
        System.out.println(dao.getJpaBookById(2));
        System.out.println(dao.getAuthorById(1));
    }
}
