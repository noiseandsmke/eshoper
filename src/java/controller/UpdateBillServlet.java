/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HoaDonDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HoaDon;

/**
 *
 * @author Nguyen
 */
public class UpdateBillServlet extends HttpServlet {

    HoaDonDAOImpl hdDao = new HoaDonDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("command").equals("update")) {
            String ma_hoa_don = request.getParameter("ma_hoa_don");
            hdDao.getHoaDon(Integer.parseInt(ma_hoa_don));
            HoaDon hd = new HoaDon();
            hd.setMa_hoa_don(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getMa_hoa_don());
            hd.setMa_tai_khoan(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getMa_tai_khoan());
            hd.setTong_tien(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getTong_tien());
            hd.setDia_chi_giao_hang(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getDia_chi_giao_hang());
            hd.setPhuong_thuc_thanh_toan(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getPhuong_thuc_thanh_toan());
            hd.setNgay_mua_hang(hdDao.getHoaDon(Integer.parseInt(ma_hoa_don)).getNgay_mua_hang());
            hd.setTinh_trang_don_hang(1);
            hdDao.updateHoaDon(hd);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/admin/manager_bill.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
