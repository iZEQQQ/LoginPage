package pl.edu.pjwstk.login.auction.model;

import pl.edu.pjwstk.login.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "bucket_elements")
public class BucketElement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime added;
    private int count;
    @JoinColumn(name = "userid")
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "auctionid")
    private Auction auction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public BucketElement() {
    }
    public BucketElement(int id, LocalDateTime added, int count, User user, Auction auction) {
        this.id = id;
        this.added = added;
        this.count = count;
        this.user = user;
        this.auction = auction;
    }
}
