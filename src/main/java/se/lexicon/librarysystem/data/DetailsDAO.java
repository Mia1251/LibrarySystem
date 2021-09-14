package se.lexicon.librarysystem.data;

import se.lexicon.librarysystem.entity.Details;

import java.util.Collection;

public interface DetailsDAO {

    Details findById(int detailsId);
    Collection<Details> findAll();
    Details create(Details detail);
    Details update(Details detail);
    void delete(int detailsId);
}


