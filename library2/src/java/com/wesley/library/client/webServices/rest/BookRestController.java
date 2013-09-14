/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.webServices.rest;


import com.wesley.library.client.web.controllers.BookController;
import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author wesley
 */
@Controller
@RequestMapping("/all-books")
public class BookRestController{
    
    @Autowired
    private BookCrudService bookCrudService;
    
    @RequestMapping("api")
    @ResponseBody
    public List<Book> books(){
        
        List<Book> books = bookCrudService.findAll();
        List<BookModel> resources = new ArrayList<BookModel>(books.size());
        
        for(Book book: books){
            
            BookModel resource = new BookModel();
            resource.setBookTitle(book.getBookTitle());
            resource.setIsbn(book.getIsbn());
            resource.setNumberOfBooks(book.getNumberOfBooks());
            
            Link detail;
            detail = ControllerLinkBuilder.linkTo(BookController.class).withSelfRel();
            //resource.add(detail);
            resources.add(resource);
        }
        return books;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Book book(@PathVariable Long id){
        Book book = bookCrudService.findById(id);
        return book;
    }
}