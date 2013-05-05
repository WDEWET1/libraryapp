/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Address;
import com.wesley.library.domain.Contact;
import com.wesley.library.domain.Demographics;
import com.wesley.library.domain.Member;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class MemberFactory {
    
    private static MemberFactory memberFactory = null;
    
    private MemberFactory(){}
    
    public static MemberFactory getInstance(){
        if(memberFactory == null){
            memberFactory = new MemberFactory();
        }
        return memberFactory;
    }
    
    public Member getMember(Map<String,String>values,Date expiryDate,Date startDate,Map<String,String>contactValues,Map<String,String>addressValues,Map<String,String>demographicsValues){
        Member member = new Member();
        member.setExpiryDate(expiryDate);
        member.setMemberID(values.get("memberID"));
        member.setStartDate(startDate);
        
        Contact contact = new Contact();
        contact.setCellPhoneNumber(contactValues.get("cellPhoneNumber"));
        contact.setEmailAddress(contactValues.get("emailAddress"));
        contact.setFax(contactValues.get("fax"));
        contact.setTelephoneNumber(contactValues.get("telephoneNumber"));
        member.setContact(contact);
        
        Address address = new Address();
        address.setPhysicalAddress(addressValues.get("physicalAddress"));
        address.setPostalAddress(addressValues.get("postalAddress"));
        address.setPostalCode(addressValues.get("postalAddress"));
        member.setAddress(address);

        Demographics demographics = new Demographics();
        demographics.setGender(demographicsValues.get("gender"));
        demographics.setRace(demographicsValues.get("race"));
        member.setDemographics(demographics);
        
        return member;
    }
}
