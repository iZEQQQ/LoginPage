package pl.edu.pjwstk.login.auction.service;

import pl.edu.pjwstk.login.auction.model.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BranchService {
    @PersistenceContext
    private EntityManager em;

    public List<Branch> findAll(){
        return em.createQuery("SELECT b FROM Branch b",Branch.class).getResultList();
    }

}
