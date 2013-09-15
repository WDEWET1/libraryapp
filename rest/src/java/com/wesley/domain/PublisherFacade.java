/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wesley
 */
@Stateless
public class PublisherFacade extends AbstractFacade<Publisher> {
    @PersistenceContext(unitName = "restPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublisherFacade() {
        super(Publisher.class);
    }
    
}
