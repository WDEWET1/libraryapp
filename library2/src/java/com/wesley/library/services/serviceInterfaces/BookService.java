/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceInterfaces;

import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public interface BookService {
    public Book createBook(Map<String,String>values, BookModel book);
}
