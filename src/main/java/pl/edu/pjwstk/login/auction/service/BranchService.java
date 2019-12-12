package pl.edu.pjwstk.login.auction.service;

import pl.edu.pjwstk.login.auction.model.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class BranchService {
    @PersistenceContext
    private EntityManager em;

    public List<Branch> findAll() {
        return em.createQuery("SELECT b FROM Branch b", Branch.class).getResultList();
    }

    @Transactional
    public void remove(Branch branch) {
        em.remove(em.merge(branch));
    }

    @Transactional
    public void save(Branch branch) {
        if (branch.getId() == null) {
            em.persist(branch);
        } else {
            em.merge(branch);
        }
    }

    public Branch find(int id) {
        return em.find(Branch.class, id);
    }
}
