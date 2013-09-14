/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.controllers;


import com.wesley.library.app.factory.BookFactory;
import com.wesley.library.client.web.models.BookModel;
import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author wesley
 */
@Controller
@SessionAttributes
public class BookController{
    private static ApplicationContext ctx;
    private static BookCrudService bookCrudService;
     
    @RequestMapping(value = "/book-result", method = RequestMethod.POST)
    public String confirm(@ModelAttribute("book")BookModel book, BindingResult result, ModelMap model)throws ParseException {
        
        
        /*
            in the first form, thats the 2 controllers below this one, we ask user to enter 
        *   data,when using the "path = whatever" that whatever variable automatically
        *   stores into your model, so in this controller, we take whatever is in the model
        *   and put in into the map, look at "book.getBookTitle" that is the model's values being put into a 
        *   map and then into factory and db.   
        */
        
        
        //---------Inserting into database------------------------------
        
        ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
        bookCrudService = (BookCrudService) ctx.getBean("BookCrudService");
        
        BookFactory bf = BookFactory.getInstance();
        
        Map<String,String>values = new HashMap<String,String>();
        values.put("bookTitle", book.getBookTitle());
        values.put("isbn", book.getIsbn());
        values.put("numberOfBooks", book.getNumberOfBooks());

        Book b = bf.getBook(values);
        bookCrudService.persist(b);
       
        //-----------Displaying to results form-----------------------------
        
        /*
         *  here im sending the "book" attribute to the form so that i can say
         *  book.variable name and it displays the specific variable u got from the user
         */
        
        model.addAttribute("book", book);
        model.addAttribute("msg","Book created successfully");
        
        return "course/book-result";
    }
    
    //  Displays form that asks user to enter stuff, just change variable names and url's.
    //  this code just displays thats all, i'll repeat, just change variables names and url's here
    //  according to your code
    @RequestMapping("/createBook")
        public ModelAndView showConfirmation()
        {
                return new ModelAndView("course/createBook" , "command" , new BookModel());
                
        }
    
    @RequestMapping(value = "/createBook", method = RequestMethod.GET)
    public String getBookForm(ModelMap model) {
        
        
        return "course/createBook";
    }

}
