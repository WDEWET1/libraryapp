/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.controllers;

import com.wesley.library.client.web.models.BookModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wesley
 */
@Controller
public class InsertController {
    //private static AddABookService addABookService;
    //private static ApplicationContext ctx;
    
    @RequestMapping(value="/Insert",method=RequestMethod.GET)
    public String home(ModelMap model,BookModel bookModel) {
        //ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
        //addABookService = (AddABookService) ctx.getBean("PersistBookService");
        
        /*BookModel m = new BookModel();
        m.setBookTitle("yep");
        m.setBookISBN("2334");
        m.setNumberOfBooks("12");
        model.addAttribute(m);
        addABookService.persistBook(m);
         */
        
        System.out.println(bookModel.getBookTitle());
        System.out.println(bookModel.getBookISBN());
        System.out.println(bookModel.getNumberOfBooks());
        
        return "Insert";
    }
}
