/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TinTucDAO;
import dao.TinTucDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen
 */
public class DeleteNewServlet extends HttpServlet {
    TinTucDAOImpl ttdao= new TinTucDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int ma_tin_tuc=Integer.parseInt(request.getParameter("ma_tin_tuc"));
           
        ttdao.deleteTinTuc(ma_tin_tuc);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_news.jsp");
        rd.forward(request, response);
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   

}
