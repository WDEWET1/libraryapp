/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.models;

/**
 *
 * @author Wesley
 */
public class BookModel{
    private String bookTitle;
    private String bookISBN;

    public BookModel() {
    }

    public BookModel(String bookTitle, String bookISBN, String numberOfBooks) {
        this.bookTitle = bookTitle;
        this.bookISBN = bookISBN;
        this.numberOfBooks = numberOfBooks;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(String numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
    private String numberOfBooks;
}
