/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAOImpl;
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
public class DeleteUserServlet extends HttpServlet {
    TaiKhoanDAOImpl tkDAO= new TaiKhoanDAOImpl();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int ma_tai_khoan=Integer.parseInt(request.getParameter("ma_tai_khoan"));
        tkDAO.deleteTaiKhoan(ma_tai_khoan);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_user.jsp");
        rd.forward(request, response);
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   

}
