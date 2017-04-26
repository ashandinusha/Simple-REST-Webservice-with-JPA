/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank.db.entity.service;

import ebank.db.entity.Customer;
import static java.net.HttpURLConnection.HTTP_OK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "EBankWebServicePU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

     @POST
    @Path("add")
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public int create(Customer entity) {
        super.create(entity);
        return HTTP_OK;
    }
    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public int edit(Customer entity) {
        super.edit(entity);
        return HTTP_OK;
    }

   @PUT
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public int  remove(Customer entity) {
        super.remove(super.find(entity.getId()));
        return HTTP_OK;
    }


    @PUT
    @Path("search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Customer find(Customer entity) {
        return super.find(entity.getId());
    }
   @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
