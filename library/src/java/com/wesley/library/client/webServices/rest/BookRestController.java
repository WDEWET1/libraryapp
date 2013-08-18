/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.webServices.rest;

import com.wesley.library.domain.Book;
import com.wesley.library.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wesley
 */

@Controller
@RequestMapping("api")
public class BookRestController {
    @Autowired
    private BookService bookService;
    @RequestMapping("books")
    @ResponseBody
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
}
