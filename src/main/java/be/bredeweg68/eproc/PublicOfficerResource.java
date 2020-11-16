package be.bredeweg68.eproc;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/publicofficer")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublicOfficerResource {
    
    @GET
    public List<PublicOfficer> list() {

        return PublicOfficer.listAll();

    }    

    @GET
    @Path("/{txt}")
    public List<PublicOfficer> view(@PathParam("txt") String txt){

        return PublicOfficer.findByText(txt);

    }     
}
