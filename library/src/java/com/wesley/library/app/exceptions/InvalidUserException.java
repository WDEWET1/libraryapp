/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.exceptions;

/**
 *
 * @author Wesley
 */
public class InvalidUserException extends RuntimeException{
    
    public InvalidUserException(String message){
        super(message);
    }
}
