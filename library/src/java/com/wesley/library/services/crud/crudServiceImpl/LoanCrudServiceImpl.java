/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Loan;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.LoanCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("LoanCrudService")
@Transactional
public class LoanCrudServiceImpl implements LoanCrudService {

    @Autowired
    private GenericDAO<Loan> dao;

    public final void setDao(final GenericDAO< Loan> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Loan.class);
    }

    public LoanCrudServiceImpl() {
    }
    @Override
    public Loan findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Loan> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Loan entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Loan entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Loan entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Loan v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Loan> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Loan getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Loan> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
