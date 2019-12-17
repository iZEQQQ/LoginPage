package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.service.AuctionService;
import pl.edu.pjwstk.login.controllers.UserContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MyAuctionList implements Serializable {
    @Inject
    private UserContext userContext;

    @Inject
    private AuctionService service;
    private List<Auction> auctionList;


    public List<Auction> getAuctionList() {
        if (auctionList == null) {
            auctionList = service.findAllAuctions(userContext.getUser());
        }
        return auctionList;
    }

    public String delete(Auction auction) {
        service.remove(auction);
        auctionList.remove(auction);
        return null;
    }


}
