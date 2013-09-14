/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceImpl;

import com.wesley.library.domain.Member;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import com.wesley.library.services.serviceInterfaces.GetMalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wesley
 */
@Service("GetMalesService")
public class GetMalesServiceImpl implements GetMalesService{

    @Autowired
    private MemberCrudService memberCrudService; 
    
    public int getNumberOfMales() {
        
        int totalNumberOfMales = 0;
        
        List<Member>members = memberCrudService.findAll();
        for(Member member: members){
            if(member.getDemographics().getGender() == "male"){
                totalNumberOfMales += 1;
            }
        }
        
        return totalNumberOfMales;
    }
}
