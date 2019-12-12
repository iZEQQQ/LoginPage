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

    @ManyToOne
    private Auction auction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionParameter that = (AuctionParameter) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numberValue, that.numberValue) &&
                Objects.equals(textValue, that.textValue) &&
                Objects.equals(auction, that.auction) &&
                Objects.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberValue, textValue, auction, parameter);
    }

    @ManyToOne
    private Parameter parameter;

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

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }


}
