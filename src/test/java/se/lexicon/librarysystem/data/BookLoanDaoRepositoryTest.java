package se.lexicon.librarysystem.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.librarysystem.model.AppUser;
import se.lexicon.librarysystem.model.Book;
import se.lexicon.librarysystem.model.BookLoan;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class BookLoanDaoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookLoanDao testObject;

    @BeforeEach
    void setUp() {
        AppUser appUser1 = new AppUser();
        Book book1 = new Book();
        BookLoan bookLoan1 = new BookLoan();

    }

    @Test
    void findById() {
        AppUser appUser1 = new AppUser();
        Book book1 = new Book();
        BookLoan newBookLoan = new BookLoan(appUser1,book1);
        BookLoan bookLoanPersisted = testObject.create(newBookLoan);
        int loanId = bookLoanPersisted.getLoanId();
        BookLoan bookLoan = testObject.findById(loanId);
        assertNotNull(bookLoan);
        assertNotNull(bookLoan.getLoanId());

    }

    @Test
    void findAll() {
        AppUser appUser1 = new AppUser();
        Book book1 = new Book();
        BookLoan newBookLoan = new BookLoan(appUser1,book1);
        BookLoan bookLoanPersisted = testObject.create(newBookLoan);
        List<BookLoan> bookLoan = (List<BookLoan>) testObject.findAll();
        assertNotNull(bookLoan);
        assertEquals(1,bookLoan.size());
    }

    @Test
    void create() {
        AppUser appUser1 = new AppUser();
        Book book1 = new Book();
        BookLoan newBookLoan = new BookLoan(appUser1,book1);
        BookLoan bookLoanPersisted = testObject.create(newBookLoan);
        assertNotNull(bookLoanPersisted);
        assertNotNull(bookLoanPersisted.getLoanId());
        assertNotNull(bookLoanPersisted.getLoanId());
        assertNotNull(bookLoanPersisted.getBook());
        assertNotNull(bookLoanPersisted.getBorrower());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

    }
}