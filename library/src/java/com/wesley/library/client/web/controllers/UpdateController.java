/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wesley
 */
@Controller
public class UpdateController {
    
    @RequestMapping(value="/Update",method=RequestMethod.GET)
    public String home(ModelMap model) {
         
        return "Update";
    }
}
