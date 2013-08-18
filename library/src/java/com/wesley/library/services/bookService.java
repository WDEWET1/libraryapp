/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services;

import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface BookService {
    public List<Book> createBook(BookModel model);
    public List<Book> deleteBook(Long id);
    public BookModel getBookToEdit(Long id);
    public List<Book> updateBook(BookModel model);
    public List<Book> getBooks();
}
