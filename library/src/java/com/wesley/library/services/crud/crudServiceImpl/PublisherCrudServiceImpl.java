/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Publisher;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.PublisherCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("PublisherCrudService")
@Transactional
public class PublisherCrudServiceImpl implements PublisherCrudService {

    @Autowired
    private GenericDAO<Publisher> dao;

    public final void setDao(final GenericDAO< Publisher> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Publisher.class);
    }

    public PublisherCrudServiceImpl() {
    }
    @Override
    public Publisher findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Publisher> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Publisher entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Publisher entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Publisher entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Publisher v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Publisher> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Publisher getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Publisher> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
