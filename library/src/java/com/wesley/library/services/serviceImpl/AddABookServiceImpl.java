/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.app.factory.BookFactory;
import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import com.wesley.library.services.serviceInterfaces.AddABookService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("PersistBookService")
public class AddABookServiceImpl implements AddABookService{

    @Autowired
    private BookCrudService bookCrudService;
    
    public void persistBook(BookModel bookM) {
        
        BookFactory bookFactory = BookFactory.getInstance();
        Map<String,String>values = new HashMap<String,String>();
        values.put("bookTitle", bookM.getBookTitle());
        values.put("isbn", bookM.getBookISBN());
        values.put("numberOfBooks", bookM.getNumberOfBooks());
        Book book = bookFactory.getBook(values);
        bookCrudService.persist(book);
    }
}
