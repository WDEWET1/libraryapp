/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import com.wesley.library.services.serviceInterfaces.AddToBooksService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("AddToBooksService")
public class AddToBooksServiceImpl implements AddToBooksService{

    @Autowired
    private BookCrudService bookCrudService; 
    
    public void addToBooks(String isbn, int numberOfBooks) {
        
        int total = 0;
        
        List<Book>books = bookCrudService.findAll();
        for(Book book: books){

            if(book.getIsbn() == isbn){
                int booksInDb = Integer.parseInt(book.getNumberOfBooks());
                booksInDb += numberOfBooks;
                String newBooksInDb = Integer.toString(booksInDb);
                book.setNumberOfBooks(newBooksInDb);
                bookCrudService.merge(book);
            }
        }
    }
}
