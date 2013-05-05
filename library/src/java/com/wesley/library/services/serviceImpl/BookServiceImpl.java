/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.services.serviceInterfaces.BookService;
import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("BookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookCrudService bookCrudService; 
    
    public String getBookName(String catID) {
        Book book = bookCrudService.getByPropertyName("bookTitle", "3 little pigs");
        return book.getBookTitle();
    }
    
}
