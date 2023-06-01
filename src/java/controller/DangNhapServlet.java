/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAOImpl;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;
import tools.MaHoa;


public class DangNhapServlet extends HttpServlet {

    private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("command").equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/MyProject/default.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_dang_nhap = request.getParameter("ten_dang_nhap");
        String mat_khau = request.getParameter("mat_khau");
        String err = "";
        TaiKhoan tk = new TaiKhoan();
        if (ten_dang_nhap.equals("") || mat_khau.equals("")) {
            err = "Vui lòng nhập đầy đủ thông tin";
        } else {
            if (taiKhoanDAO.kiemTraDangNhap(ten_dang_nhap, MaHoa.MaHoaMD5(mat_khau)) == false) {
                err = "Email hoặc mật khẩu không chính xác";
            }

        }
        if (err.length() > 0) {
            request.setAttribute("err", err);
        }
        String url = "/account.jsp";
        try {
            if (err.length() == 0) {
                int t = taiKhoanDAO.getTaiKhoan(ten_dang_nhap).getQuyen_truy_cap();
                if (t == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", ten_dang_nhap);

                    url = "/default.jsp";
                }
                if (t == 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", ten_dang_nhap);
                    url = "/admin/index.jsp";
                }

            } else {
                url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (Exception e) {
        }

    }

}
