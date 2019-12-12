package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.service.AuctionService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AuctionEdit implements Serializable {
    @Inject
    private AuctionService service;
    private Auction auction;

    public Auction getAuction(){
        if(auction == null){
            auction = new Auction();
        }
        return auction;
    }
    //TODO dodac xhtml z aukcjami
    public String save(){
        service.save(auction);
        return "/auction/auction_list?faces-redirect=true";
    }
}
