/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import com.sun.jersey.api.spring.Autowire;
import javax.persistence.EntityManager;
import com.wesley.library.domain.Supplier;
import java.net.URI;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wesley
 */
@Path("com.wesley.library.domain.supplier")
@com.sun.jersey.spi.resource.Singleton
@Autowire
public class SupplierRESTFacade {
    @PersistenceContext(unitName = "libraryPU")
    protected EntityManager entityManager;

    public SupplierRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Transactional
    public Response create(Supplier entity) {
        entityManager.persist(entity);
        return Response.created(URI.create(entity.getId().toString())).build();
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Transactional
    public void edit(Supplier entity) {
        entityManager.merge(entity);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void remove(@PathParam("id") Long id) {
        Supplier entity = entityManager.getReference(Supplier.class, id);
        entityManager.remove(entity);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    @Transactional
    public Supplier find(@PathParam("id") Long id) {
        return entityManager.find(Supplier.class, id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Transactional
    public List<Supplier> findAll() {
        return find(true, -1, -1);
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    @Transactional
    public List<Supplier> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return find(false, max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @Transactional
    public String count() {
        try {
            Query query = entityManager.createQuery("SELECT count(o) FROM Supplier AS o");
            return query.getSingleResult().toString();
        } finally {
            entityManager.close();
        }
    }

    private List<Supplier> find(boolean all, int maxResults, int firstResult) {
        try {
            Query query = entityManager.createQuery("SELECT object(o) FROM Supplier AS o");
            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
}
