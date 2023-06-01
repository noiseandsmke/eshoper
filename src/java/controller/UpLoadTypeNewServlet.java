/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoaiTinDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoaiTin;



public class UpLoadTypeNewServlet extends HttpServlet {
    LoaiTinDAOImpl loaiTinDAO= new LoaiTinDAOImpl();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ten_loai_tin=request.getParameter("TenLoaiTin");
        loaiTinDAO.insertLoaiTin(new LoaiTin(ten_loai_tin));
         RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_typenew.jsp");
        rd.forward(request, response);
        
        
    }

   }
