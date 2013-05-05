/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.crud.crudServiceImpl;

import com.wesley.library.domain.Member;
import com.wesley.library.repository.GenericDAO;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("MemberCrudService")
@Transactional
public class MemberCrudServiceImpl implements MemberCrudService {

    @Autowired
    private GenericDAO<Member> dao;

    public final void setDao(final GenericDAO< Member> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Member.class);
    }

    public MemberCrudServiceImpl() {
    }
    @Override
    public Member findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Member> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Member entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Member entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Member entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Member v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Member> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Member getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Member> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
