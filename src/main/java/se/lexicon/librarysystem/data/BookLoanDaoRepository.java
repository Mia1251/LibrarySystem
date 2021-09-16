package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.librarysystem.model.Book;
import se.lexicon.librarysystem.model.BookLoan;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class BookLoanDaoRepository implements BookLoanDao {

    private EntityManager em;

    @Autowired
    public BookLoanDaoRepository(EntityManager em){
        this.em = em;}

    @Override
    public BookLoan findById(int bookLoanId) {
        return em.find(BookLoan.class,bookLoanId);
    }

    @Override
    public Collection<BookLoan> findAll() {
        List<BookLoan> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From BookLoan a", BookLoan.class).getResultList();
        return foundAll;
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        em.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return em.merge(bookLoan);
    }

    @Override
    public void delete(int bookLoanId) {
        BookLoan toRemove = findById(bookLoanId);
        if(toRemove != null){
            em.remove(toRemove);
        }else {
            throw new IllegalArgumentException("Bookloan could not be found");
        }
    }
}
