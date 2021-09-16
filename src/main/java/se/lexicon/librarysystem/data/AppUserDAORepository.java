package se.lexicon.librarysystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.librarysystem.model.AppUser;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AppUserDAORepository implements AppUserDAO{

    private EntityManager em;

    @Autowired
    public AppUserDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public AppUser findById(int AppUserId) {
        return em.find(AppUser.class,AppUserId);
    }

    @Override
    @Transactional
    public Collection<AppUser> findAll() {
        List<AppUser> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From AppUser a", AppUser.class).getResultList();
        return foundAll;
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        em.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return em.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int AppUserId) {
        AppUser toRemove = findById(AppUserId);
        if(toRemove != null){
            em.remove(toRemove);
        }else {
            throw new IllegalArgumentException("AppUser could not be found");
        }
    }
}
