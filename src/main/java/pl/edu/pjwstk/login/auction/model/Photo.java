package pl.edu.pjwstk.login.auction.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Photo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String link;

    @ManyToOne
    private Auction auction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) &&
                Objects.equals(link, photo.link) &&
                Objects.equals(auction, photo.auction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link, auction);
    }
}
