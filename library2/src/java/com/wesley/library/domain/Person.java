/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.domain;

import java.util.Map;

/**
 *
 * @author Wesley
 */
public interface Person {
    public Contact getContact();
    public Address getAddress();
    public Demographics getDemographics();
    public Contact setContact(Contact contact);
    public Address setAddress(Address address);
    public Demographics setDemographics(Demographics demographics);
}
