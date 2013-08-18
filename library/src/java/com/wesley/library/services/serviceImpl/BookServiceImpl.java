/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

/**
 *
 * @author Wesley
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import com.wesley.library.services.BookService;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author boniface
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookCrudService bookCrudService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Book> createBook(BookModel model) {
        Book book = new Book(); // DONT DO THIS USE FACTORY
        book.setIsbn(model.getIsbn());
        book.setBookTitle(model.getBooktitle());
        book.setNumberOfBooks(model.getNumberOfBooks());
        bookCrudService.persist(book);
        return bookCrudService.findAll();
    }

    @Override
    public List<Book> deleteBook(Long id) {
        bookCrudService.removeById(id);
        return bookCrudService.findAll();
    }

    @Override
    public BookModel getBookToEdit(Long id) {
        BookModel model = new BookModel();
        Book book = bookCrudService.findById(id);
        model.setBooktitle(book.getBookTitle());
        model.setIsbn(book.getIsbn());
        model.setNumberOfBooks(book.getNumberOfBooks());
        model.setId(id);
        return model;
    }
    @Override
    public List<Book> updateBook(BookModel model) {
        Book book = new Book(); // DONT DO THIS USE FACTORY
        book.setBookTitle(model.getBooktitle());
        book.setIsbn(model.getIsbn());
        book.setNumberOfBooks(model.getNumberOfBooks());
        book.setId(model.getId());
        bookCrudService.merge(book);
        return bookCrudService.findAll();
    }

    @Override
    public List<Book> getBooks() {
        return bookCrudService.findAll();
        }
}

