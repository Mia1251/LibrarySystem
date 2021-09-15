package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.librarysystem.entity.Author;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AuthorDAORepository implements AuthorDAO {

    private EntityManager em;

    @Autowired
    public AuthorDAORepository(EntityManager em){
        this.em = em;
    }



    @Override
    @Transactional
    public Author findById(int authorId) {
        return em.find(Author.class,authorId);
    }

    @Override
    @Transactional
    public Collection<Author> findAll() {
        List<Author> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From Author a", Author.class).getResultList();
        return foundAll;
    }

    @Override
    @Transactional
    public Author create(Author author) {
        em.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return em.merge(author);
    }

    @Override
    @Transactional
    public void delete(int AuthorId) {
    Author toRemove = findById(AuthorId);
        if(toRemove != null){
        em.remove(toRemove);
    }else {
        throw new IllegalArgumentException("Author could not be found");
    }
}
}
