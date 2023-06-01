/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class UpLoadCategoryServlet extends HttpServlet {

    private DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String TenDanhMuc = request.getParameter("TenDanhMuc");

        String url = "/admin/manager_category.jsp";
        String erro = "";
        if (TenDanhMuc.equals("")) {
            erro = "Bạn phải nhập tên danh mục";

        }
        if (erro.length() > 0) {
            request.setAttribute("erro", erro);
        }
        try {
            if (erro.length() == 0) {
                
                danhMucDAO.insertDanhMuc(new DanhMuc(TenDanhMuc));
                url = "/admin/manager_category.jsp";

            } else {
                url = "/admin/insert_category.jsp";

            }
            RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
        }

    }

}
