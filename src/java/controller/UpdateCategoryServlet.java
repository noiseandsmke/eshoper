/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;

/**
 *
 * @author Nguyen
 */
public class UpdateCategoryServlet extends HttpServlet {
    DanhMucDAOImpl danhmucDAO= new DanhMucDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_danh_muc = request.getParameter("TenDanhMuc");
        String ma_danh_muc = request.getParameter("ma_danh_muc");
        String url="",erro="";
         if(ten_danh_muc.equals(""))
         {
             erro="Ban phai nhap ten danh muc";
         }
         //danhmucDAO.updateDanhMuc(new DanhMuc(Integer.parseInt(ma_danh_muc),ten_danh_muc));
         danhmucDAO.updateDanhMuc(new DanhMuc(Integer.parseInt(ma_danh_muc),ten_danh_muc));
         url="/admin/manager_category.jsp";
         RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
         rd.forward(request, response);
          
    }

}
