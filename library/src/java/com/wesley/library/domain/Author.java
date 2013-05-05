/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Wesley
 */
@Entity
public class Author implements Serializable,Person{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorName;
    private String authorID;
    
    @ManyToMany
    private List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
    
    @Embedded
    private Contact contact;
    
    @Embedded
    private Address address;

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    @Embedded
    private Demographics demographics;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    private String authorLastName;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesley.library.domain.Author[ id=" + id + " ]";
    }

    public Contact getContact(Map<String, String> values) {
        return contact;
    }

    public Address getAddress(Map<String, String> values) {
        return address;
    }

    public Demographics getDemographics(Map<String, String> values) {
        return demographics;
    }

    public Contact setContact(Contact contact) {
       return this.contact = contact;
    }

    public Address setAddress(Address address) {
       return this.address = address;
    }

    public Demographics setDemographics(Demographics demographics) {
        return this.demographics = demographics;
    }

    
}
