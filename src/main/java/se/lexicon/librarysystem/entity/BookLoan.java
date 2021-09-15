package se.lexicon.librarysystem.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    @Column(unique = true)
    private LocalDate loanDate;
    private LocalDate dueDate;
    private Boolean returned;
    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private AppUser borrower;
    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private Book book;

    public BookLoan() {
    }

    public BookLoan(AppUser borrower, Book book){
        this.borrower = borrower;
        this.book = book;
    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate, Boolean returned, AppUser borrower, Book book) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate) && Objects.equals(returned, bookLoan.returned) && Objects.equals(borrower, bookLoan.borrower) && Objects.equals(book, bookLoan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanDate, dueDate, returned, borrower, book);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
