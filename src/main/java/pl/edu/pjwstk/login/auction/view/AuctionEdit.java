package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.AuctionService;
import pl.edu.pjwstk.login.auction.service.CategoryService;
import pl.edu.pjwstk.login.controllers.UserService;
import pl.edu.pjwstk.login.model.User;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AuctionEdit implements Serializable {
    @Inject
    private CategoryService categoryService;

    @Inject
    private AuctionService service;
    private Auction auction;
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        if (categoryList == null) {
            categoryList = categoryService.findAllCategories();
        }
        return categoryList;
    }



    public Auction getAuction() {
        if (auction == null) {
            auction = new Auction();
        }
        return auction;
    }

    public String save() {
        service.save(auction);
        return "/auction/auction_list?faces-redirect=true";
    }
}
