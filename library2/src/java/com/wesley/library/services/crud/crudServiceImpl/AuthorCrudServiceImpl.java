/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Author;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.AuthorCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("AuthorCrudService")
@Transactional
public class AuthorCrudServiceImpl implements AuthorCrudService {

    @Autowired
    private GenericDAO<Author> dao;

    public final void setDao(final GenericDAO< Author> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Author.class);
    }

    public AuthorCrudServiceImpl() {
    }
    @Override
    public Author findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Author> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Author entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Author entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Author entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Author v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Author> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Author getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Author> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
