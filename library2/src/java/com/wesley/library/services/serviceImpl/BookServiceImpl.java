/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import com.wesley.library.services.serviceInterfaces.BookService;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wesley
 */

@Service("createBook")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookCrudService bookCrudService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Book createBook(Map<String,String>values) {
        return null;
    }   

    public Book createBook(Map<String, String> values, BookModel book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

