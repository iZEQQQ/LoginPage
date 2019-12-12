package pl.edu.pjwstk.login.auction.service;

import pl.edu.pjwstk.login.auction.model.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoService {

    @PersistenceContext
    private EntityManager em;

    public List<Photo> findAllPhotos() {
        return em.createQuery("SELECT p FROM Photo p", Photo.class).getResultList();
    }

    @Transactional
    public void addPhoto(Photo photo) {
        em.persist(photo);
    }

    @Transactional
    public void deletePhoto(Photo photo) {
        em.remove(em.merge(photo));
    }


}
