package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.model.Book;

import java.util.Collection;

public interface BookDAO {
    Book findById(int bookId);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int bookId);
}
