/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Supplier;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class SupplierFactory {
    
    private static SupplierFactory supplierFactory = null;
    
    private SupplierFactory(){}
    
    public static SupplierFactory getInstance(){
        if(supplierFactory == null){
            supplierFactory = new SupplierFactory();
        }
        return supplierFactory;
    }
    
    public Supplier getSupplier(Map<String,String>values){
        Supplier supplier = new Supplier();
        supplier.setSupplierID(values.get("supplierID"));
        supplier.setSupplierLastName(values.get("supplierLastName"));
        supplier.setSupplierName(values.get("supplierName"));
        return supplier;
    }
}
