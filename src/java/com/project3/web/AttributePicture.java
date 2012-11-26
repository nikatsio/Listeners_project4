
package com.project3.web;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class AttributePicture implements ServletContextAttributeListener {
    
    static int pictures = 0;
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent e) {
        int imgCount = ++pictures;
        if(e.getName().equals("image" + imgCount)) {++pictures;}
    }
    
    public static int uploads() {
    
        return pictures;
    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent e) {}
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent e) {}
}