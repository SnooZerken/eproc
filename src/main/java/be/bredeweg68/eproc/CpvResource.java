package be.bredeweg68.eproc;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cpv")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CpvResource {
    
    @GET
    public List<Cpv> list() {

        return Cpv.listAll();

    }    

    @GET
    @Path("/{txt}")
    public List<Cpv> view(@PathParam("txt") String txt){

        return Cpv.findByText(txt);

    }     
}
