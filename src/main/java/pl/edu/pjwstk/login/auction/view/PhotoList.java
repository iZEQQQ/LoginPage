package pl.edu.pjwstk.login.auction.view;

import pl.edu.pjwstk.login.auction.model.Photo;
import pl.edu.pjwstk.login.auction.service.PhotoService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PhotoList implements Serializable {

    @Inject
    private PhotoService service;
    private List<Photo> photoList;

    public List<Photo> getPhotoList(){
        if(photoList == null){
            photoList = service.findAllPhotos();
        }
        return photoList;
    }

    public String delete(Photo photo){
        service.deletePhoto(photo);
        photoList.remove(photo);
        return null;
    }




}
