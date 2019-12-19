package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Parameter;
import pl.edu.pjwstk.login.auction.service.ParamService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ParamEdit implements Serializable {
    @Inject
    private ParamService service;
    private Parameter parameter;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Parameter getParameter() {
        if (parameter == null) {
            if (id == null) {
                parameter = new Parameter();
            } else {
                parameter = service.find(id);
            }
        }
        return parameter;
    }


    // TODO poprawisave parametru
    public String save() {
        service.addParam(parameter);
        return null;
    }


}
