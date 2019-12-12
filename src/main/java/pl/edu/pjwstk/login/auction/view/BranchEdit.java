package pl.edu.pjwstk.login.auction.view;

import pl.edu.pjwstk.login.auction.model.Branch;
import pl.edu.pjwstk.login.auction.service.BranchService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class BranchEdit implements Serializable {
    @Inject
    private BranchService service;
    private Branch branch;

    public Branch getBranch() {
        if (branch == null) {
            branch = new Branch();
        }
        return branch;
    }

    public String save() {
        service.save(branch);

        return "/auction/branch_list?faces-redirect=true";
    }

}
