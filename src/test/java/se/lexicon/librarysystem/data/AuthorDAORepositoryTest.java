package se.lexicon.librarysystem.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.librarysystem.entity.AppUser;
import se.lexicon.librarysystem.entity.Author;
import se.lexicon.librarysystem.entity.Book;
import se.lexicon.librarysystem.entity.BookLoan;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class AuthorDAORepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorDAO testObject;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        Author newAuthor = new Author();
        Author authorPersisted = testObject.create(newAuthor);
        int authorId = authorPersisted.getAuthorId();
        Author author1 = testObject.findById(authorId);
        assertNotNull(author1);
        assertNotNull(author1.getAuthorId());
    }

    @Test
    void findAll() {
        Author author1 = new Author();
        Author authorPersisted = testObject.create(author1);
        List<Author> authors = (List<Author>) testObject.findAll();
        assertNotNull(authors);
        assertEquals(1,authors.size());
    }

    @Test
    void create(){
        Author newAuthor = new Author();

        Author authorPersisted = testObject.create(newAuthor);
        assertNotNull(authorPersisted);
        assertNotNull(authorPersisted.getAuthorId());

    }

    @Test
    void update() {
        Author newAuthor = new Author("A", "B");
        String firstName = "Mark";
        String lastName = "Twain";
        newAuthor.setFirstName(firstName);
        newAuthor.setLastName(lastName);
        Author updated = testObject.update(newAuthor);

        assertEquals(firstName,updated.getFirstName());
    }

    @Test
    void delete() {
        Author newAuthor = new Author();
        Author authorPersisted = testObject.create(newAuthor);
        int id1 = authorPersisted.getAuthorId();

        assertNotNull(authorPersisted);

        testObject.delete(authorPersisted.getAuthorId());

        assertNull(entityManager.find(Author.class, id1), "Author was Found!");
    }
}