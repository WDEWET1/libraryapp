/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.app.factory;

import com.wesley.library.domain.Category;
import java.util.Map;

/**
 *
 * @author Wesley
 */
public class CategoryFactory {
    
    private static CategoryFactory categoryFactory = null;
    
    private CategoryFactory(){}
    
    public static CategoryFactory getInstance(){
        if(categoryFactory == null){
            categoryFactory = new CategoryFactory();
        }
        return categoryFactory;
    }
    
     public Category getCategory(Map<String,String>values){
        Category category = new Category();
        category.setAgeRestriction(values.get("ageRestriction"));
        category.setCategoryCode(values.get("categoryCode"));
        category.setCategoryName(values.get("categoryName"));
         
        return category;
    }
}
