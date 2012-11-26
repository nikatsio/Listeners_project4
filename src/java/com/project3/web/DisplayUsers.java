package com.project3.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class DisplayUsers extends HttpServlet {
  HttpSession session;  
  
    @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
  throws IOException, ServletException {

    
    session= request.getSession();
    request.getServletContext();
    //request.getServletRequest();
    synchronized (session) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        
        out.println("<h3>Session Data:</h3>");
        out.println("New session: " + session.isNew());
        out.println("<br>Current users:" + ConcurrentUserTracker.getConcurrentUsers());
        out.println("<br>Session ID: " + session.getId());
        out.println("<br>Your's sesion creation time: " + new Date(session.getCreationTime()));
        out.println("<br>Your's sesion last accessed time: " + new Date(session.getLastAccessedTime()));
        
        out.println("<h3>Contex Data:</h3>");
        if(MyServletContextListener.Data()==1){
            out.println("<br>The Web App. has been online and initilized with these parameters:");
            out.println("<br> where the file uploaded:" + getServletContext().getInitParameter("file-upload"));
        }
        else{
            out.println("The Simple Web App. Has Been Removed");
        }
        
        out.println("<h3>Request Data:</h3>");
        if(MyServletContextListener.Data()==1){
            out.println("<br> Request numbers:" + ReqListener.Rnumber());
            out.println("<br> Servlet used for this request: " + (request instanceof HttpServletRequest ? ((HttpServletRequest) request).getRequestURI()
                  : "Unknown"));
        }
        else{
            out.println("The Simple Web App. Has Been Removed");
        }
        
        out.println("<h3>Uploads Data:</h3>");
        out.println("<br> Upload pictures:" + AttributePicture.uploads());
        
        out.println("</html>");
    }
  }
}
