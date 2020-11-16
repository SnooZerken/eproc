package be.bredeweg68.eproc;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/organisation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OrganisationResource {

    @GET
    public List<Organisation> list() {

        return Organisation.listAll();

    }    

    @GET
    @Path("/{id}")
    public Organisation view(@PathParam("id") Long id){

        return Organisation.findById(id);

    } 

    @POST
    public Organisation save(Organisation organisation){

        organisation.persist();
        return organisation;

    }

    @PUT
    @Path("/{id}")
    public Organisation update(@PathParam("id") Long id, Organisation org){

        Organisation organisation = Organisation.findById(id);

        if(org.name != null)
            organisation.name = org.name;

        if(org.acronym != null)
            organisation.acronym = org.acronym;

        organisation.persist();
        return organisation;

    }   

    @DELETE
    @Path("/{id}")
    public boolean delete(@PathParam("id") Long id){

        return Organisation.deleteById(id);

    }

}