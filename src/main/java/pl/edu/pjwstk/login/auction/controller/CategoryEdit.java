package pl.edu.pjwstk.login.auction.controller;


import pl.edu.pjwstk.login.auction.model.Branch;
import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.BranchService;
import pl.edu.pjwstk.login.auction.service.CategoryService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class CategoryEdit implements Serializable {

    @Inject
    private BranchService branchService;

    @Inject
    private CategoryService service;
    private Category category;
    private List<Branch> branchList;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Branch> getBranchList() {
        if (branchList == null) {
            branchList = branchService.findAll();
        }
        return branchList;
    }

    public Category getCategory() {
        if (category == null) {
            if (id == null) {
                category = new Category();
            } else {
                category = service.find(id);
            }
        }
        return category;
    }

    public String saveCategory() {
        service.addCategory(category);
        return "/auction/category_list?faces-redirect=true";
    }


}
