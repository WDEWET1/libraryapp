/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.services.serviceInterfaces;

import com.wesley.library.client.web.models.BookModel;


/**
 *
 * @author Wesley
 */
public interface AddABookService {
    public void persistBook(BookModel bookM);
}
