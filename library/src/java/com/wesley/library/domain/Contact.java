/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.domain;

import java.io.Serializable;

/**
 *
 * @author Wesley
 */
public class Contact implements Serializable{
    private String emailAddress;
    private String cellPhoneNumber;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    private String telephoneNumber;
    private String fax;
}
