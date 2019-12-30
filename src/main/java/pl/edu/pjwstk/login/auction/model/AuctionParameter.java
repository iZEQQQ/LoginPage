package pl.edu.pjwstk.login.auction.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_value")
    private Long numberValue;
    @Column(name = "text_value")
    private String textValue;
    @Column(name = "parameter_name")
    private String name;


    @ManyToOne
    private Auction auction;

    public AuctionParameter() {
    }


    public AuctionParameter(Auction auction, String textValue, String name) {
        this.auction = auction;
        this.textValue = textValue;
        this.name = name;
    }

    public AuctionParameter(Auction auction, Long numberValue, String name) {
        this.auction = auction;
        this.numberValue = numberValue;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionParameter that = (AuctionParameter) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numberValue, that.numberValue) &&
                Objects.equals(textValue, that.textValue) &&
                Objects.equals(auction, that.auction) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberValue, textValue, auction, name);
    }

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

    public Long getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Long numberValue) {
        this.numberValue = numberValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

}
