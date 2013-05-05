/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Supplier;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.SupplierCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("SupplierCrudService")
@Transactional
public class SupplierCrudServiceImpl implements SupplierCrudService {

    @Autowired
    private GenericDAO<Supplier> dao;

    public final void setDao(final GenericDAO< Supplier> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Supplier.class);
    }

    public SupplierCrudServiceImpl() {
    }
    @Override
    public Supplier findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Supplier> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Supplier entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Supplier entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Supplier entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Supplier v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Supplier> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Supplier getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Supplier> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
