package pl.edu.pjwstk.login.auction.service;


import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionService {

    @PersistenceContext
    private EntityManager em;

    public List<Auction> findAllAuctions() {
        return em.createQuery("SELECT a FROM Auction a", Auction.class).getResultList();
    }

    @Transactional
    public void remove(Auction auction) {
        em.remove(em.merge(auction));
    }

    @Transactional
    public void save(Auction auction) {
        if (auction.getId() == null) {
            em.persist(auction);
        } else {
            em.merge(auction);
        }
    }

    public Auction find(int id) {
        return em.find(Auction.class, id);
    }

    public List<Auction> findAllAuctions(User user) {
        return em.createQuery("SELECT a FROM Auction  a WHERE a.user = :user", Auction.class)
                .setParameter("user", user).getResultList();
    }
}
