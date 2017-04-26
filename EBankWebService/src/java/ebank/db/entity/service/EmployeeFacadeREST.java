/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank.db.entity.service;

import ebank.db.entity.Employee;
import static java.net.HttpURLConnection.HTTP_OK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("employee")
public class EmployeeFacadeREST extends AbstractFacade<Employee> {

    @PersistenceContext(unitName = "EBankWebServicePU")
    private EntityManager em;

    public EmployeeFacadeREST() {
        super(Employee.class);
    }

    @POST
    @Path("add")
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public int create(Employee entity) {
        super.create(entity);
        return HTTP_OK;
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public int edit(Employee entity) {
        super.edit(entity);
        return HTTP_OK;
    }

    @PUT
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public int remove(Employee entity) {
        super.remove(super.find(entity.getId()));
        return HTTP_OK;
    }

    @PUT
    @Path("search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Employee find(Employee entity) {
        return super.find(entity.getId());
    }

    @PUT
    @Path("login")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Employee login(Employee entity) {
        try {
            Employee e = (Employee) getEntityManager().createNamedQuery("Employee.login").setParameter("userName",
                    entity.getUserName()).setParameter("password", entity.getPassword()).getSingleResult();
            return e;
        } catch (NoResultException e) {
            return null;
        }
    }

     @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Employee> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employee> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
