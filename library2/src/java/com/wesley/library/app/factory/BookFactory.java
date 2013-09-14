/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Book;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class BookFactory {
    
    private static BookFactory bookFactory = null;
    
    private BookFactory(){}
    
    public static BookFactory getInstance(){
        if(bookFactory == null){
            bookFactory = new BookFactory();
        }
        return bookFactory;
    }
    
    public Book getBook(Map<String,String>values){
        Book book = new Book();
        book.setBookTitle(values.get("bookTitle"));
        book.setIsbn(values.get("isbn"));
        book.setNumberOfBooks(values.get("numberOfBooks"));
        return book;
    }
}
