package ru.gb.lesson4.hw.jpa;

import jakarta.persistence.EntityManager;
import ru.gb.lesson4.hw.entities.Book;
import ru.gb.lesson4.hw.entities.Author;
import ru.gb.lesson4.hw.entities.JpaBook;

import java.util.List;


public class JpaDao {
    private EntityManagerProvider provider;

    public JpaDao(EntityManagerProvider provider) {
        this.provider = provider;
    }

    public void saveAuthor(Author author) {
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public void saveBook(Book object) {
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public void saveJpaBook(JpaBook book, Author author) {
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        book.setAuthor(author);
        author.getBooks().add(book);
        entityManager.persist(book);
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public JpaBook getJpaBookById(long id){
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        JpaBook jpaBook = entityManager.find(JpaBook.class, id);
        entityManager.getTransaction().commit();
        return jpaBook;
    }

    public Author getAuthorById(long id){
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        return author;
    }

    public List<Book> findBookByAuthor(String author) {
        String sql = "select * from books where author = '" + author + "'";
        EntityManager entityManager = provider.getEntityManager();
        entityManager.getTransaction().begin();
        List<Book> resultList = entityManager
                .createNativeQuery(sql, Book.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }
}
