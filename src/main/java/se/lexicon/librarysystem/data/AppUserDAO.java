package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.model.AppUser;

import java.util.Collection;

public interface AppUserDAO {
   AppUser findById(int AppUserId);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int AppUserId);
}
