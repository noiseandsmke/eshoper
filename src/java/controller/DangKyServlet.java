/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;
import tools.MaHoa;


public class DangKyServlet extends HttpServlet {

    private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_dang_nhap = request.getParameter("ten_dang_nhap");
        String ten_tai_khoan = request.getParameter("ten_tai_khoan");
        String mat_khau = request.getParameter("mat_khau");
        String ten_dang_nhap_err = "", ten_tai_khoan_err = "", mat_khau_err = "";
        if (ten_tai_khoan.equals("")) {
            ten_tai_khoan_err = "Vui lòng nhập Họ tên của bạn !";
        }
        if (ten_tai_khoan_err.length() > 0) {
            request.setAttribute("ten_tai_khoan_err", ten_tai_khoan_err);
        }
        if (ten_dang_nhap.equals("")) {
            ten_dang_nhap_err = "Vui lòng nhập Email của bạn";
        } else {
            if (taiKhoanDAO.kiemTraTaiKhoan(ten_dang_nhap) == true) {
                ten_dang_nhap_err = "Địa chỉ Email đã tồn tại";
            }
        }
        if (ten_dang_nhap_err.length() > 0) {
            request.setAttribute("ten_dang_nhap_err", ten_dang_nhap_err);
        }
        if (mat_khau.equals("")) {
            mat_khau_err = "Vui lòng nhập mật khẩu";
        }
        if (mat_khau_err.length() > 0) {
            request.setAttribute("mat_khau_err", mat_khau_err);
        }
        request.setAttribute("ten_tai_khoan", ten_tai_khoan);
        request.setAttribute("ten_dang_nhap", ten_dang_nhap);
        request.setAttribute("mat_khau", mat_khau);
        String url = "/account.jsp";
        try {
            if (mat_khau_err.length() == 0 && ten_dang_nhap_err.length() == 0 && ten_tai_khoan_err.length() == 0) {

                TaiKhoan tk = new TaiKhoan(ten_tai_khoan, ten_dang_nhap, MaHoa.MaHoaMD5(mat_khau), 1);
                taiKhoanDAO.themTaiKhoan(tk);
                url = "/index.jsp";

            } else {
                url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
