package pl.edu.pjwstk.login.auction.resource;

import pl.edu.pjwstk.login.auction.model.Auction;
import pl.edu.pjwstk.login.auction.model.Category;
import pl.edu.pjwstk.login.auction.service.AuctionService;

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
public class AuctionResource {

    @Inject
    private AuctionService service;

    @Path("auctions")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Response getAuctions(){
        List<Auction> auctions = service.findAllAuctions();
        return Response.ok(auctions).build();
    }

    @Path("branches/{branch}/categories/{category}/auctions")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Response getAuctions(@PathParam("branch") String branch,@PathParam("category") String category){
        List<Auction> categories = service.findAuctionsByBranchAndCategory(branch,category);
        return Response.ok(categories).build();
    }







}
