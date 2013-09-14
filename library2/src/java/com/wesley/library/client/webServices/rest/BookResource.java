/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.webServices.rest;

import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Wesley
 */
public class BookResource extends ResourceSupport{
    String bookTitle;
    String isbn;
    String numberOfBooks;
}
