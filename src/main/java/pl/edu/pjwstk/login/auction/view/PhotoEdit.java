package pl.edu.pjwstk.login.auction.view;


import pl.edu.pjwstk.login.auction.model.Photo;
import pl.edu.pjwstk.login.auction.service.PhotoService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class PhotoEdit implements Serializable {

    @Inject
    private PhotoService service;
    private Photo photo;

    public Photo getPhoto(){
        if(photo == null){
            photo = new Photo();
        }
        return photo;
    }
    //TODO poprawisave photo
    public String savePhoto(){
        service.addPhoto(photo);
        return null;
    }
}
