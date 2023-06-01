/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;
import tools.MaHoa;

/**
 *
 * @author Nguyen
 */
public class UpLoadUserServlet extends HttpServlet {

    TaiKhoanDAOImpl tkDAO = new TaiKhoanDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String TenTaiKhoan = request.getParameter("TenTaiKhoan");
        String TenDangNhap = request.getParameter("TenDangNhap");
        String MatKhau = request.getParameter("TenDangNhap");
        String QuyenTruyCap = request.getParameter("QuyenTruyCap");
        String url = "";
        String TenTaiKhoan_err = "", TenDangNhap_err = "", MatKhau_err = "", QuyenTruyCap_err = "", TinhTrang_err = "";
        if (TenTaiKhoan.equals("")) {
            TenTaiKhoan_err = "Vui lòng nhập Họ tên ";
        }
        if (TenDangNhap_err.length() > 0) {
            request.setAttribute("TenTaiKhoan_err", TenTaiKhoan_err);
        }
        if (TenDangNhap.equals("")) {
            TenDangNhap_err = "Vui Lòng nhập Email";
        } else {
            if (tkDAO.kiemTraTaiKhoan(TenDangNhap) == true) {
                TenDangNhap_err = "Địa chỉ Email đã tồn tại";
            }
        }
        if (TenDangNhap_err.length() > 0) {
            request.setAttribute("TenDangNhap_err", TenDangNhap_err);
        }
        if (MatKhau.equals("")) {
            MatKhau_err = "Vui lòng nhập mật khẩu";
        }
        if (MatKhau_err.length() > 0) {
            request.setAttribute("MatKhau_err", MatKhau_err);
        }
        if (QuyenTruyCap.equals("")) {
            QuyenTruyCap_err = "Vui lòng nhập quyền truy cập";
        }
        if (QuyenTruyCap_err.length() > 0) {
            request.setAttribute("QuyenTruyCap_err", QuyenTruyCap_err);
        }
       
        request.setAttribute("TenTaiKhoan", TenTaiKhoan);
        request.setAttribute("TenDangNhap", TenDangNhap);
        request.setAttribute("MatKhau", MatKhau);
        request.setAttribute("QuyenTruyCap", QuyenTruyCap);
      
        try {
            if (TenTaiKhoan_err.length() == 0 && TenDangNhap_err.length() == 0 && MatKhau_err.length() == 0 && QuyenTruyCap_err.length() == 0
                    && TinhTrang_err.length() == 0) {
                TaiKhoan tk = new TaiKhoan(TenTaiKhoan, TenDangNhap, MaHoa.MaHoaMD5(MatKhau), Integer.parseInt(QuyenTruyCap));
                tkDAO.themTaiKhoan(tk);
                url = "/admin/manager_user.jsp";
            } else {
                url = "/admin/insert_user.jsp";
            }

        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
