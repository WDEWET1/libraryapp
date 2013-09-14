/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import com.wesley.library.services.serviceInterfaces.GetAllBooksService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("GetAllBooksService")
public class GetAllBooksServiceImpl implements GetAllBooksService{

    @Autowired
    private BookCrudService bookCrudService;
    
    public List<Book> getAllBooks() {
        List<Book> allBooks = bookCrudService.findAll();
        
        return allBooks;
    }
    
}
