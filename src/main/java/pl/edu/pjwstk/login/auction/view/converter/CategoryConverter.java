package pl.edu.pjwstk.login.auction.view.converter;

import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.CategoryService;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Dependent
@FacesConverter(forClass = Category.class,managed = true)
public class CategoryConverter implements Converter<Category> {
@Inject
private CategoryService service;

    @Override
    public Category getAsObject(FacesContext context, UIComponent component, String value) {
        return service.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Category value) {
        return value.getId().toString();
    }
}
