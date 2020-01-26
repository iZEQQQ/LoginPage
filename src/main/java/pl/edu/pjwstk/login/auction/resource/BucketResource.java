package pl.edu.pjwstk.login.auction.resource;

import pl.edu.pjwstk.login.auction.model.BucketElement;
import pl.edu.pjwstk.login.auction.service.BucketService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("")
public class BucketResource {
    @Inject
    private BucketService service;

    @Path("bucket/elements")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Response getBucket() {
        List<BucketElement> bucketElements = service.findAllForUser();
        return Response.ok(bucketElements).build();
    }

    @Path("bucket/elements")
    @Consumes({MediaType.APPLICATION_JSON})
    @POST
    public Response addToBucket(AddToBucketRequest add) {
        service.addToBucket(add.getAuctionid());
        return Response.ok().build();
    }
}
