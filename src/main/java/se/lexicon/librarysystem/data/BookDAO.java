package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.entity.AppUser;
import se.lexicon.librarysystem.entity.Book;

import java.util.Collection;

public interface BookDAO {
    Book findById(int bookId);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int bookId);
}
