package pl.edu.pjwstk.login.auction.view.converter;

import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.service.AuctionService;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Dependent
@FacesConverter(forClass = Auction.class, managed = true)
public class AuctionConverter implements Converter<Auction> {
    @Inject
    private AuctionService service;

    @Override
    public Auction getAsObject(FacesContext context, UIComponent component, String value) {
        return service.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Auction value) {
        return value.getId().toString();
    }
}
