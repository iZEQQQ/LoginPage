package pl.edu.pjwstk.login.auction.view;

import pl.edu.pjwstk.login.auction.model.Branch;
import pl.edu.pjwstk.login.auction.service.BranchService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class BranchList implements Serializable {

    @Inject
    private BranchService service;
    private List<Branch> branchList;

    public List<Branch> getBranchList() {
        if (branchList == null) {
            branchList = service.findAll();
        }
        return branchList;
    }
}
