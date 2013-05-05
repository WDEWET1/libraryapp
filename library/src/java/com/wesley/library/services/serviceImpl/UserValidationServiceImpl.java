/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.app.exceptions.InvalidUserException;
import com.wesley.library.domain.Users;
import com.wesley.library.services.crud.crudServices.UsersCrudService;
import com.wesley.library.services.serviceInterfaces.UserValidationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("UserValidationService")
public class UserValidationServiceImpl implements UserValidationService{

    @Autowired
    private UsersCrudService usersCrudService; 
    
    public String getUser(String username, String password) {
        
        String u = "";
        
        List<Users>allUsers = usersCrudService.findAll();
        for(Users user: allUsers){
           
            user = usersCrudService.getByPropertyName("userName", username);
            user = usersCrudService.getByPropertyName("password", password);

            if((user.getPassword() == password) && (user.getUserName() == username)){
                u = "Senior Librarian";
            }else{
                throw new InvalidUserException("Invalid username and password, Please re-enter");
            }
        }
        return u;
    }    
}
