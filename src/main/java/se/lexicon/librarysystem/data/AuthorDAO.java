package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.librarysystem.entity.AppUser;
import se.lexicon.librarysystem.entity.Author;

import javax.persistence.EntityManager;
import java.util.Collection;

public interface AuthorDAO {
    Author findById(int authorId);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int authorI);
}
