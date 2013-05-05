/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Address;
import com.wesley.library.domain.Author;
import com.wesley.library.domain.Contact;
import com.wesley.library.domain.Demographics;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class AuthorFactory{
    
    private static AuthorFactory authorFactory = null;
    
    private AuthorFactory(){}
    
    public static AuthorFactory getInstance(){
        if(authorFactory == null){
            authorFactory = new AuthorFactory();
        }
        return authorFactory;
    }
    
    public Author getAuthor(Map<String,String>values,Map<String,String>contactValues,Map<String,String>addressValues,Map<String,String>demographicsValues ){
        Author author = new Author();
        author.setAuthorID(values.get("authorID"));
        author.setAuthorName(values.get("authorName"));
        author.setAuthorLastName(values.get("authorLastName"));
        author.setCountry(values.get("country"));

        Contact contact = new Contact();
        contact.setCellPhoneNumber(contactValues.get("cellPhoneNumber"));
        contact.setEmailAddress(contactValues.get("emailAddress"));
        contact.setFax(contactValues.get("fax"));
        contact.setTelephoneNumber(contactValues.get("telephoneNumber"));
        author.setContact(contact);
        
        Address address = new Address();
        address.setPhysicalAddress(addressValues.get("physicalAddress"));
        address.setPostalAddress(addressValues.get("postalAddress"));
        address.setPostalCode(addressValues.get("postalAddress"));
        author.setAddress(address);

        Demographics demographics = new Demographics();
        demographics.setGender(demographicsValues.get("gender"));
        demographics.setRace(demographicsValues.get("race"));
        author.setDemographics(demographics);
        
        return author;
    }
}
