package com.project3.web;

import javax.servlet.http.*;

public class ConcurrentUserTracker implements HttpSessionListener {
  static private int users = 0;

    @Override
  public void sessionCreated(HttpSessionEvent e) {
      
    
    synchronized (this) {
        users++;
        
    }
  }
    @Override
  public void sessionDestroyed(HttpSessionEvent e) {
    
    
    synchronized (this) {
        users--;
    }
    
  }
  public static int getConcurrentUsers() {
    
    return users;
  }
}
