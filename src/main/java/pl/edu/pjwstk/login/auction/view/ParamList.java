package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Parameter;
import pl.edu.pjwstk.login.auction.service.ParamService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class ParamList implements Serializable {

    @Inject
    private ParamService service;
    private List<Parameter> parameterList;

    public List<Parameter> getParameterList() {
        if (parameterList == null) {
            parameterList = service.findAllParams();
        }
        return parameterList;
    }

    public String delete(Parameter parameter) {
        service.deleteParam(parameter);
        parameterList.remove(parameter);
        return null;
    }

}
