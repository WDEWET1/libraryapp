/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Book;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("BookCrudService")
@Transactional
public class BookCrudServiceImpl implements BookCrudService {

    @Autowired
    private GenericDAO<Book> dao;

    public final void setDao(final GenericDAO< Book> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Book.class);
    }

    public BookCrudServiceImpl() {
    }
    @Override
    public Book findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Book> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Book entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Book entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Book entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Book v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Book> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Book getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Book> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
