/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SanPhamDAOImpl;
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
public class DeleteProductServlet extends HttpServlet {
    SanPhamDAOImpl sanPhamDAO= new SanPhamDAOImpl();
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_san_pham=Integer.parseInt(request.getParameter("ma_san_pham"));
          sanPhamDAO.deleteSanPham(ma_san_pham);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_product.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
