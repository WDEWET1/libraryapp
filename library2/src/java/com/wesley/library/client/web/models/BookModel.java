/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.models;

import java.io.Serializable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author boniface
 */
public class BookModel implements Serializable{

    private Long id;
    private String bookTitle;
    private String isbn;
    private String numberOfBooks;

    
    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(String numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
