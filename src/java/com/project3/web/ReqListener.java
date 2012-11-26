
package com.project3.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ReqListener implements ServletRequestListener {

  private static int reqCount=0;

    @Override
  public void requestInitialized(ServletRequestEvent sre) {

    ServletContext context = sre.getServletContext();

    synchronized (context) {
       ++reqCount;
    }

  }

    @Override
  public void requestDestroyed(ServletRequestEvent sre) {
      
      
        --reqCount;
      
  }
  
  public static int Rnumber() {
    
    return reqCount;
  }

}
