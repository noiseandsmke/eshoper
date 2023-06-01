/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.SendMail;

/**
 *
 * @author Nguyen
 */
public class SendMessageServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=(String) request.getParameter("name");
        String email=(String)request.getParameter("email");
        String subject=(String)request.getParameter("subject");
        String message =(String)request.getParameter("message");
        String url="";
        
     SendMail sm= new SendMail();
     sm.sendMail(email,"Xin chaò tôi là :"+name +subject,message );
     url="/default.jsp";
        RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
     
       
    }

   
}
