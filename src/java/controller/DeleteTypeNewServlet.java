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

/**
 *
 * @author Nguyen
 */
public class DeleteTypeNewServlet extends HttpServlet {

    LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_loai_tin = Integer.parseInt(request.getParameter("ma_loai_tin"));
        String msgDelete = "Chọn danh chức năng mà bạn muốn ?";
        if (loaiTinDAO.deleteLoaiTin(ma_loai_tin)) {
            msgDelete = "Xoa thanh cong!";
            request.setAttribute("msgDelete", msgDelete);

        }
        else
        {
             msgDelete = "Xóa không thành công ! Bạn cần xóa hếttin tức thuộc loại tin này !";
            request.setAttribute("msgDelete", msgDelete);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_typenew.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
