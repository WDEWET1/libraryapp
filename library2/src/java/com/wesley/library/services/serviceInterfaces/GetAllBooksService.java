/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceInterfaces;

import com.wesley.library.domain.Book;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface GetAllBooksService {
    public List<Book> getAllBooks();
}
