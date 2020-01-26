package pl.edu.pjwstk.login.auction.service;

import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.model.BucketElement;
import pl.edu.pjwstk.login.controllers.UserContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BucketService {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserContext userContext;

    @Transactional
    public List<BucketElement> findAllForUser() {
        List<BucketElement> list = em.createQuery("SELECT be FROM BucketElement be WHERE be.user =:user ORDER BY be.added DESC ", BucketElement.class)
                .setParameter("user", userContext.getUser())
                .getResultList();
        if (!list.isEmpty() && list.get(0).getAdded().plusDays(30).isBefore(LocalDateTime.now())) {
            for (BucketElement bucketElement : list) {
                em.remove(bucketElement);
            }
            return new ArrayList<>();
        }
        return list;
    }

    @Transactional
    public void addToBucket(int auctionId) {
        try {
            BucketElement element = em.createQuery("SELECT be FROM BucketElement be WHERE be.user =:user AND be.auction.id = :id ", BucketElement.class)
                    .setParameter("id", auctionId)
                    .setParameter("user", userContext.getUser())
                    .getSingleResult();
            element.setCount(element.getCount() + 1);
            element.setAdded(LocalDateTime.now());
        } catch (NoResultException ex) {
            Auction auction = em.createQuery("SELECT a FROM Auction a WHERE a.id =:id", Auction.class)
                    .setParameter("id", auctionId).getSingleResult();
            BucketElement element = new BucketElement();
            element.setUser(userContext.getUser());
            element.setAuction(auction);
            element.setAdded(LocalDateTime.now());
            em.persist(element);
        }
    }
}
