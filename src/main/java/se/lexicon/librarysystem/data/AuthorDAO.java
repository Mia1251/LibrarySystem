package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.model.Author;

import java.util.Collection;

public interface AuthorDAO {
    Author findById(int authorId);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int authorI);
}
