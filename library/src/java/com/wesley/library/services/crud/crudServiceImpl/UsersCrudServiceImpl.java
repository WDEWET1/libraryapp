/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Users;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.UsersCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("UsersCrudService")
@Transactional
public class UsersCrudServiceImpl implements UsersCrudService {

    @Autowired
    private GenericDAO<Users> dao;

    public final void setDao(final GenericDAO< Users> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Users.class);
    }

    public UsersCrudServiceImpl() {
    }
    @Override
    public Users findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Users> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Users entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Users entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Users entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Users v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Users> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Users getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Users> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
