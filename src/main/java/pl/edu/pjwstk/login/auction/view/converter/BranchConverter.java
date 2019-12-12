package pl.edu.pjwstk.login.auction.view.converter;

import pl.edu.pjwstk.login.auction.model.Branch;
import pl.edu.pjwstk.login.auction.service.BranchService;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Dependent
@FacesConverter(forClass = Branch.class, managed = true)
public class BranchConverter implements Converter<Branch> {
    @Inject
    private BranchService service;


    @Override
    public Branch getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println(service);
        System.out.println(value);
        return service.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Branch value) {
        return value.getId().toString();
    }
}
