package rest;

import entities.Company;
import exception.CompanyNotFoundException;
import facade.CompanyFacade;
import facade.ICompanyFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author sebastiannielsen
 */
@Path("company")
public class RestServiceCompany {

    @Context
    private UriInfo context;

    @Context
    ServletContext servletContext;

    ICompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("CA2_dev"));

    public RestServiceCompany() {
    }

    @GET
    @Path("{complete}")
    @Produces("application/json")
    public Response getCompanies() {
        List<Company> companies = facade.getCompanies();
        return Response.ok(JSONConverter.getJSONFromCompany(companies)).build();
    }

    @GET
    @Path("{cvr}")
    @Produces("application/json")
    public Response getCompany(@PathParam("cvr") long cvr){
        try {
            Company c = facade.getCompany(cvr);
            return Response.ok(JSONConverter.getJSONFromCompany(c)).build();
        } catch (CompanyNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes("application/json")
    public Response createCompany(String company) {
        Company c = JSONConverter.getCompanyFromJson(company);
        return Response.status(Response.Status.CREATED).entity(facade.createCompany(c)).build();
    }

    @PUT
    @Consumes("application/json")
    public Response editCompany(String company) {
        Company c = JSONConverter.getCompanyFromJson(company);
        try {
            return Response.ok(facade.editCompany(c)).build();
        } catch (CompanyNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{delete/cvr}")
    public Response deleteCompany(@PathParam("cvr") long cvr){
        try {
            return Response.ok(facade.deleteCompany(cvr)).build();
        } catch (CompanyNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
