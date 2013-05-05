/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Publisher;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class PublisherFactory {
    
    private static PublisherFactory publisherFactory = null;
    
    private PublisherFactory(){}
    
    public static PublisherFactory getInstance(){
        if(publisherFactory == null){
            publisherFactory = new PublisherFactory();
        }
        return publisherFactory;
    }
    
    public Publisher getPublisher(Map<String,String>values,Date datePublished){
        Publisher publisher = new Publisher();
        publisher.setDatePublished(datePublished);
        publisher.setPublisherID(values.get("publisherID"));
        publisher.setPublisherName(values.get("publisherName"));
        return publisher;
    } 
}
