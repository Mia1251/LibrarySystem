package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {
    BookLoan findById(int bookLoanId);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int bookLoanId);
}
