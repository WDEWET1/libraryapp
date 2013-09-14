/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.domain.Member;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import com.wesley.library.services.serviceInterfaces.PostalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("PostalService")
public class PostalServiceImpl implements PostalService{
    
    @Autowired
    private MemberCrudService memberCrudService; 

    public int getNumberOfMembersInSpecificArea(String area){
        
        int total = 0;
        
        List<Member>members = memberCrudService.findAll();
        for(Member member: members){
            if(member.getAddress().getPostalCode() == area){
                total = total + 1;
            }
        }
        return total;
    }
}
