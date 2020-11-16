package be.bredeweg68.eproc;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/nature")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NatureResource {

    
    @GET
    public List<Nature> list() {

        return Nature.listAll();

    }    

    @GET
    @Path("/{txt}")
    public List<Nature> view(@PathParam("code") String txt){

        return Nature.findByText(txt);

    } 
    
}
