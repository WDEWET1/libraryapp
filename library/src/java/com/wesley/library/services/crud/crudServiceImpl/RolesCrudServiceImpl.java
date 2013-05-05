/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Roles;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.RolesCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("RolesCrudService")
@Transactional
public class RolesCrudServiceImpl implements RolesCrudService {

    @Autowired
    private GenericDAO<Roles> dao;

    public final void setDao(final GenericDAO< Roles> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Roles.class);
    }

    public RolesCrudServiceImpl() {
    }
    @Override
    public Roles findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Roles> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Roles entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Roles entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Roles entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Roles v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Roles> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Roles getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Roles> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
