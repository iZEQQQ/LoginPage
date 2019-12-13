package pl.edu.pjwstk.login.auction.service;


import pl.edu.pjwstk.login.auction.model.AuctionParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AuctionParamService {

    @PersistenceContext
    private EntityManager em;

    public List<AuctionParameter> findAllAuctionParam(){
        return em.createQuery("SELECT ap FROM AuctionParameter ap ",AuctionParameter.class).getResultList();
    }


}
