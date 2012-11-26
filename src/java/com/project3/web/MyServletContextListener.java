
package com.project3.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public  class MyServletContextListener implements ServletContextListener {
  
  private static int flag;
  //ServletContext context;

    @Override
  public void contextDestroyed(ServletContextEvent event)
  {
    flag=0;

  }

    @Override
  public void contextInitialized(ServletContextEvent event)
  {
    //context = event.getServletContext();
    flag=1;

  }
  
  public static int Data() {
    
    return flag;
  }
}