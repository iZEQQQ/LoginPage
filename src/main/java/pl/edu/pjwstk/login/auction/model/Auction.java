package pl.edu.pjwstk.login.auction.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.edu.pjwstk.login.model.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Auction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    @DecimalMin("0")
    private Double price;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private List<AuctionParameter> auctionParameterList = new ArrayList<>();

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private List<Photo> photoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return Objects.equals(id, auction.id) &&
                Objects.equals(title, auction.title) &&
                Objects.equals(description, auction.description) &&
                Objects.equals(price, auction.price) &&
                Objects.equals(auctionParameterList, auction.auctionParameterList) &&
                Objects.equals(photoList, auction.photoList) &&
                Objects.equals(user, auction.user) &&
                Objects.equals(category, auction.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, auctionParameterList, photoList, user, category);
    }

    @ManyToOne
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public List<AuctionParameter> getAuctionParameterList() {
        return auctionParameterList;
    }

    public void setAuctionParameterList(List<AuctionParameter> auctionParameterList) {
        this.auctionParameterList = auctionParameterList;
    }

    public Photo getFirstPhoto() {
        if (photoList == null) {
            return null;
        } else {
            return photoList.get(0);
        }
    }


    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
