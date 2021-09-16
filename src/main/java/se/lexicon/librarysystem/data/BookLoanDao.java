package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.model.BookLoan;

import java.util.Collection;

public interface BookLoanDao {
    BookLoan findById(int bookLoanId);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int bookLoanId);
}
