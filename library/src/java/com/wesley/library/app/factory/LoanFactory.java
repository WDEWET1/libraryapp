/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Loan;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class LoanFactory {
    
    private static LoanFactory loanFactory = null;
    
    private LoanFactory(){}
    
    public static LoanFactory getInstance(){
        if(loanFactory == null){
            loanFactory = new LoanFactory();
        }
        return loanFactory;
    }
    
    public Loan getLoan(Map<String,String>values,Date startDate, Date dueDate){
        Loan l = new Loan();
        l.setBookName(values.get("bookName"));
        l.setDueDate(dueDate);
        l.setStartDate(startDate);
        return l;
    }
}
