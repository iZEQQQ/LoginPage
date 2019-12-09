package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.CategoryService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class CategoryEdit implements Serializable {

    @Inject
    private CategoryService service;
    private Category category;

    public Category getCategory() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }

    public String saveCategory(){
        service.addCategory(category);
        return "/auction/category_list?faces-redirect=true";
    }


}
