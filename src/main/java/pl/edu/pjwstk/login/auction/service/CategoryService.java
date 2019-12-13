package pl.edu.pjwstk.login.auction.service;


import pl.edu.pjwstk.login.auction.model.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {

    @PersistenceContext
    private EntityManager em;

    public List<Category> findAllCategories() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @Transactional
    public void addCategory(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }

    @Transactional
    public void deleteCategory(Category category) {
        em.remove(em.merge(category));
    }

}
