/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.controllers;

import com.wesley.library.client.web.models.Welcome;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wesley
 */
@Controller
public class IndexController {
     @RequestMapping(value="/",method=RequestMethod.GET)
    public String home(ModelMap model) {
         //DON'T CREATE OBJECTS LIKE THIS, USE FACTORIES
         Welcome message = new Welcome();
         Date d = new Date(12,3,23);
         message.setToday(d);
         message.setWelcome("Welcome to the Home Page");
         model.addAttribute("msg", message);
        return "index";
    }
    
}
