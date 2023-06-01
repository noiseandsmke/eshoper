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
import model.TaiKhoan;

/**
 *
 * @author Nguyen
 */
public class UpdateTaikhoanServlet extends HttpServlet {
    TaiKhoanDAOImpl taiKhoanDao= new TaiKhoanDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String TenTaiKhoan=request.getParameter("TenTaiKhoan");
        String TenDangNhap=request.getParameter("TenDangNhap");
        String MatKhau=request.getParameter("MatKhau");
        int QuyenTruyCap=Integer.parseInt(request.getParameter("QuyenTruyCap"));
       
        String ma_tai_khoan=request.getParameter("ma_tai_khoan");
        taiKhoanDao.updateTaiKhoan(new TaiKhoan(Integer.parseInt(ma_tai_khoan), TenTaiKhoan, TenDangNhap, MatKhau, QuyenTruyCap));
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/admin/manager_user.jsp");
         rd.forward(request, response);
        
                

    }

}
