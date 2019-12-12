package pl.edu.pjwstk.login.auction.service;


import pl.edu.pjwstk.login.auction.model.Parameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ParamService {

    @PersistenceContext
    private EntityManager em;

    public List<Parameter> findAllParams(){
        return em.createQuery("SELECT p FROM Parameter p", Parameter.class).getResultList();
    }

    @Transactional
    public void addParam(Parameter parameter){
        em.persist(parameter);
    }

    @Transactional
    public void deleteParam(Parameter parameter){
        em.remove(em.merge(parameter));
    }



}
