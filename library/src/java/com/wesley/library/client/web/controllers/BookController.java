/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.controllers;

import com.wesley.library.app.factory.BookFactory;
import com.wesley.library.domain.Book;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wesley
 */
@Controller
public class BookController {
    
    @RequestMapping(value="/Book",method=RequestMethod.GET)
    public String home(ModelMap model) {
        
        return "Book";
    }
}
