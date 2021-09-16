package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.librarysystem.model.Details;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class DetailsDAORepository implements DetailsDAO {

    private EntityManager em;

    @Autowired
    public DetailsDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public Details findById(int detailsId) {
        return em.find(Details.class,detailsId);
    }

    @Override
    @Transactional
    public Collection<Details> findAll() {
        List<Details> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From Details a", Details.class).getResultList();
        return foundAll;
    }

    @Override
    @Transactional
    public Details create(Details detail) {
        em.persist(detail);
        return detail;
    }

    @Override
    @Transactional
    public Details update(Details detail) {
        return em.merge(detail);
    }

    @Override
    @Transactional
    public void delete(int detailsId) {
        Details toRemove = findById(detailsId);
        if(toRemove != null){
            em.remove(toRemove);
        }else {
            throw new IllegalArgumentException("Details could not be found");
        }
    }
}