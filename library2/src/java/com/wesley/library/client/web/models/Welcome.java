/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.web.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author boniface
 */
public class Welcome implements Serializable{
    
    private String welcome;
    private Date today;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
    
    
    
}
