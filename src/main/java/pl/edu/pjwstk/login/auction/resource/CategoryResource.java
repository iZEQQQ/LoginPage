package pl.edu.pjwstk.login.auction.resource;

import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("")
public class CategoryResource {
    @Inject
    private CategoryService service;

    @Path("branches/{branch}/categories")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Response getCategories(@PathParam("branch") String branch){
        List<Category> categories = service.findCategoriesByBranch(branch);
        return Response.ok(categories).build();
    }



}
