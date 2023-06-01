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

/**
 *
 * @author Nguyen
 */
public class UpdateTypeNewServlet extends HttpServlet {

    LoaiTinDAOImpl loaiTinDAO= new LoaiTinDAOImpl();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_loai_tin = request.getParameter("TenLoaiTin");
        String ma_loai_tin = request.getParameter("ma_loai_tin");
        String url="",erro="";
         if(ten_loai_tin.equals(""))
         {
             erro="Ban phai nhap ten";
         }
         //danhmucDAO.updateDanhMuc(new DanhMuc(Integer.parseInt(ma_danh_muc),ten_danh_muc));
         loaiTinDAO.updateLoaiTin(new LoaiTin(Integer.parseInt(ma_loai_tin), ten_loai_tin));
         url="/admin/manager_typenew.jsp ";
         RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
         rd.forward(request, response);
          }

    
}
