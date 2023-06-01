/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SanPhamDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;
import utils.UploadFileUtils;

/**
 *
 * @author Nguyen
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UpdateProductServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
       String MaSanPham=request.getParameter("ma_san_pham");
        String TenSanPham = request.getParameter("TenSanPham");
      
        int MaDanhMuc = Integer.parseInt(request.getParameter("MaDanhMuc"));
          
         String image = UploadFileUtils.UploadFile(request);
        int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
        int DonGia = Integer.parseInt(request.getParameter("DonGia")); 
        int GiamGia =Integer.parseInt(request.getParameter("GiamGia"));
        String ManHinh=request.getParameter("ManHinh");
        String CameraSau=request.getParameter("CameraSau");
        String CameraTruoc=request.getParameter("CameraTruoc");
        String HeDieuHanh=request.getParameter("HeDieuHanh");
        String Cpu=request.getParameter("Cpu");
        String BoNho=request.getParameter("BoNho");
        String Ram=request.getParameter("Ram");
        String KetNoi=request.getParameter("KetNoi");
        String PinSac=request.getParameter("PinSac");
        String BaoHanh=request.getParameter("BaoHanh");
        String MoTa=request.getParameter("MoTa");
        SanPhamDAOImpl sanPhamDAO= new SanPhamDAOImpl();
        sanPhamDAO.updateSanPham(new SanPham(Integer.parseInt(MaSanPham), TenSanPham,MaDanhMuc,image, SoLuong, DonGia, GiamGia, ManHinh, CameraSau, CameraTruoc, HeDieuHanh, Cpu, BoNho, Ram, KetNoi, PinSac,BaoHanh, MoTa));
          request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
       
    }

   

}
