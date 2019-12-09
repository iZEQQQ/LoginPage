package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.CategoryService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CategoryList implements Serializable {

    @Inject
    private CategoryService service;
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        if (categoryList == null) {
            categoryList = service.findAllCategories();
        }
        return categoryList;
    }

    public String delete(Category category) {
        service.deleteCategory(category);
        categoryList.remove(category);
        return null;
    }

}
