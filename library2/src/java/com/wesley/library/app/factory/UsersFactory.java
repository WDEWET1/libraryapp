/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;
import com.wesley.library.domain.Users;
import java.util.Map;


/**
 *
 * @author Wesley
 */
public class UsersFactory {
    
    private static UsersFactory usersFactory = null;
    
    private UsersFactory(){}
    
    public static UsersFactory getInstance(){
        if(usersFactory == null){
            usersFactory = new UsersFactory();
        }
        return usersFactory;
    }
    
    public Users getUser(Map<String,String>values){
        Users u = new Users();
        u.setPassword(values.get("password"));
        u.setUserName(values.get("userName"));
        return u;
    }
}
