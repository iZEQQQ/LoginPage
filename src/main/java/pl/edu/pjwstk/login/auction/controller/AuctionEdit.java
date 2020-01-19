package pl.edu.pjwstk.login.auction.controller;


import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.model.AuctionParameter;
import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.model.Photo;
import pl.edu.pjwstk.login.auction.service.AuctionService;
import pl.edu.pjwstk.login.auction.service.CategoryService;
import pl.edu.pjwstk.login.controllers.UserContext;

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
    private UserContext userContext;

    @Inject
    private AuctionService service;
    private Auction auction;
    private List<Category> categoryList;
    private String newImageUrl;
    private Integer id;
    private String textParam;
    private Long numParam;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewImageUrl() {
        return newImageUrl;
    }

    public void setNewImageUrl(String newImageUrl) {
        this.newImageUrl = newImageUrl;
    }

    public List<Category> getCategoryList() {
        if (categoryList == null) {
            categoryList = categoryService.findAllCategories();
        }
        return categoryList;
    }

    public Auction getAuction() {
        if (auction == null) {
            if (id == null) {
                auction = new Auction();
            } else {
                auction = service.find(id);
            }
        }
        return auction;
    }

    public String save() {
        auction.setUser(userContext.getUser());
        service.save(auction);
        return "/auction/my_auction_list?faces-redirect=true";
    }

    public String addImage() {
        auction.getPhotoList().add(new Photo(newImageUrl, auction));
        newImageUrl = null;
        return null;
    }

    public String removePhoto(Photo photo) {
        auction.getPhotoList().remove(photo);
        return null;
    }

    public AuctionParameter addAuctionTextParam() {
        auction.getAuctionParameterList().add(new AuctionParameter(auction, textParam, name));
        return null;
    }

    public AuctionParameter addAuctionNumParam() {
        auction.getAuctionParameterList().add(new AuctionParameter(auction, numParam, name));
        return null;
    }

    public String getTextParam() {
        return textParam;
    }

    public void setTextParam(String textParam) {
        this.textParam = textParam;
    }

    public Long getNumParam() {
        return numParam;
    }

    public void setNumParam(Long numParam) {
        this.numParam = numParam;
    }

    public AuctionParameter removeParameter(AuctionParameter parameter) {
        auction.getAuctionParameterList().remove(parameter);
        return null;
    }
}
