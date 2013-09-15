/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Wesley
 */
@Embeddable
public class Address implements Serializable{
    private String physicalAddress;
    private String postalAddress;

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    private String postalCode;
}
