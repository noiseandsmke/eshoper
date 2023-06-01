/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author Nguyen
 */
//@WebServlet("/SearchPriceServlet")
public class SearchPriceServlet extends HttpServlet {

    private SanPhamDAO sanPhamDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String min=request.getParameter("gia1");
        String max=request.getParameter("gia2");
           System.out.println("list: "+min);
        ArrayList<SanPham> listPrice = sanPhamDao.getListSanPhamByPrice(min, max);
        System.out.println("list: "+listPrice);
        request.setAttribute("listPrice",listPrice);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/SearchView.jsp");
        rd.forward(request, response);
      
    }

   
}
