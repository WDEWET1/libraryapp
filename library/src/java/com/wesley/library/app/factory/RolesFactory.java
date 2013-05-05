/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Roles;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class RolesFactory {
    
    private static RolesFactory rolesFactory = null;
    
    private RolesFactory(){}
    
    public static RolesFactory getInstance(){
        if(rolesFactory == null){
            rolesFactory = new RolesFactory();
        }
        return rolesFactory;
    }
    
    public Roles getRoles(Map<String,String>values){
        Roles r = new Roles();
        r.setRoleName(values.get("roleName"));
        r.setUserName(values.get("userName"));
        r.setDescription(values.get("description"));
        return r;
    }
}
