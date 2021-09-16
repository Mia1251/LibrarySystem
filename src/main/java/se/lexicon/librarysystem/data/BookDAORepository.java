package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.librarysystem.model.Book;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class BookDAORepository implements BookDAO {

    private EntityManager em;

    @Autowired
    public BookDAORepository(EntityManager em){
        this.em = em;}

    @Override
    public Book findById(int bookId) {
        return em.find(Book.class,bookId);
    }

    @Override
    public Collection<Book> findAll() {
        List<Book> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From Book a", Book.class).getResultList();
        return foundAll;
    }

    @Override
    public Book create(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return em.merge(book);
    }

    @Override
    public void delete(int bookId) {
        Book toRemove = findById(bookId);
        if(toRemove != null){
            em.remove(toRemove);
        }else {
            throw new IllegalArgumentException("Book could not be found");
        }
    }
}
