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
public class SupplierFacade extends AbstractFacade<Supplier> {
    @PersistenceContext(unitName = "restPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplierFacade() {
        super(Supplier.class);
    }
    
}
