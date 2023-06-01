/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen
 */
public class DeleteCategoryServlet extends HttpServlet {

    DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msgDelete = "";
        int ma_danh_muc = Integer.parseInt(request.getParameter("ma_danh_muc"));
        if (danhMucDAO.deleteDanhMuc(ma_danh_muc)) {
            msgDelete = "Xoa thanh cong!";
            request.setAttribute("msgDelete", msgDelete);

        } else {
            msgDelete = "Ban can xoa het san pham thuoc danh muc nay!";
            request.setAttribute("msgDelete", msgDelete);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_category.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
