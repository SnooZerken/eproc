package be.bredeweg68.eproc;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.bredeweg68.eproc.ValidationGroups.Create;
import be.bredeweg68.eproc.ValidationGroups.Update;

@Path("/dossier")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DossierResource {

    @Inject
    Validator validator;

    @GET
    public Response list() {

        return Response.ok(Dossier.listAll()).build();

    }

    @GET
    @Path("/{id}")
    public Response view(@PathParam("id") Long id) {

        return Response.ok(Dossier.findById(id)).build();

    }

    @GET
    @Path("/find/{txt}")
    public Response find(@PathParam("id") String txt) {

        return Response.ok(Dossier.findByText(txt)).build();

    }

    @POST
    public Response save(Dossier dossier) {

        ValidationResult r = dossier.validate(Create.class);

        if(!r.isSuccess()){
            return Response.ok(r.getValidationErrors()).build();
        }

        dossier.persist();
        return Response.ok(dossier).build();

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Dossier dos) {

        Dossier dossier = Dossier.findById(id);

        if (dossier == null)
            return Response.noContent().build();

        ValidationResult r = dos.validate(Update.class);

        if(!r.isSuccess()){
            return Response.ok(r.getValidationErrors()).build();
        }

        if (dos.reference != null)
            dossier.reference = dos.reference;

        if (dos.title != null)
            dossier.title = dos.title;

        if (dos.organisation != null)
            dossier.organisation = dos.organisation;

        if (dos.description != null)
            dossier.description = dos.description;

        if (dos.estimatedamount != null)
            dossier.estimatedamount = dos.estimatedamount;

        if (dos.awardedamount != null)
            dossier.awardedamount = dos.awardedamount;

        if (dos.mainnature != null)
            dossier.mainnature = dos.mainnature;

        if (dos.additionalnatures != null && dos.additionalnatures.size() > 0) {
            dossier.additionalnatures = dos.additionalnatures;
        }

        if (dos.maincpv != null)
            dossier.maincpv = dos.maincpv;

        if (dos.additionalcpvs != null && dos.additionalcpvs.size() > 0) {
            dossier.additionalcpvs = dos.additionalcpvs;
        }

        if (dos.proceduretype != null)
            dossier.proceduretype = dos.proceduretype;

        if (dos.contactpoint != null)
            dossier.contactpoint = dos.contactpoint;

        return Response.ok(dossier).build();

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        return Response.ok(Dossier.deleteById(id)).build();

    }

}
