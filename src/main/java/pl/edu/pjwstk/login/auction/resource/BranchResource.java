package pl.edu.pjwstk.login.auction.resource;

import pl.edu.pjwstk.login.auction.model.Branch;
import pl.edu.pjwstk.login.auction.service.BranchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("")
public class BranchResource {
    @Inject
    private BranchService service;

    @Path("branches")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Response getBranch() {
        List<Branch> branches = service.findAll();
        return Response.ok(branches).build();
    }
}
