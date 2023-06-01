/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChiTietHoaDonDAOImpl;
import dao.HoaDonDAOImpl;
import dao.SanPhamDAOImpl;
import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ChiTietHoaDon;
import model.GioHang;
import model.HoaDon;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author Nguyen
 */
public class ThanhToanServlet extends HttpServlet {

    private final HoaDonDAOImpl hoaDonDAO = new HoaDonDAOImpl();
    private final ChiTietHoaDonDAOImpl chiTietHoaDonDAO = new ChiTietHoaDonDAOImpl();
    private final TaiKhoanDAOImpl taiKhoanDAOI = new TaiKhoanDAOImpl();
    private final SanPhamDAOImpl sanphamDAO= new SanPhamDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String dia_chi_giao_hang = request.getParameter("dia_chi_giao_hang");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String phuong_thuc_thanh_toan = request.getParameter("phuong_thuc_thanh_toan");

        String dia_chi_erro = "", phuong_thuc_erro = "", so_dien_thoai_err = "";
        if (dia_chi_giao_hang.equals("")) {
            dia_chi_erro = "Vui lòng nhập địa chỉ giao hàng";
        }
        if (so_dien_thoai.equals("")) {
            so_dien_thoai_err = "Vui lòng nhập số điện thoai";
        }
        if (dia_chi_erro.length() > 0) {
            request.setAttribute("dia_chi_erro", dia_chi_erro);
        }
        if (phuong_thuc_thanh_toan.equals("")) {
            phuong_thuc_erro = "Vui lòng nhập phương thức thanh toán";
        }
        if (phuong_thuc_erro.length() > 0) {
            request.setAttribute("phuong_thuc_erro", phuong_thuc_erro);
        }
         if(so_dien_thoai_err.length()>0)
         {
             request.setAttribute("so_dien_thoai_err", so_dien_thoai_err);
         }
        request.setAttribute("dia_chi_giao_hang", dia_chi_giao_hang);
        request.setAttribute("so_dien_thoai",so_dien_thoai);
        request.setAttribute("phuong_thuc_thanh_toan", phuong_thuc_thanh_toan);

        if (dia_chi_erro.length() == 0 && so_dien_thoai_err.length()==0) {

            HttpSession session = request.getSession();
            GioHang cart = (GioHang) session.getAttribute("cart");
            String taikhoan = (String) session.getAttribute("username");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(new Date());
                int ID = (int) new Date().getTime();
                HoaDon hd = new HoaDon();
                hd.setMa_hoa_don(ID);
                hd.setMa_tai_khoan(taiKhoanDAOI.getTaiKhoan(taikhoan).getMa_tai_khoan());
                hd.setTong_tien(cart.total());
                hd.setDia_chi_giao_hang(dia_chi_giao_hang);
                hd.setSo_dien_thoai(so_dien_thoai);
                hd.setPhuong_thuc_thanh_toan(phuong_thuc_thanh_toan);
                hd.setNgay_mua_hang(date);
                hd.setTinh_trang_don_hang(0);

                hoaDonDAO.themHoaDon(hd);
                TreeMap<SanPham, Integer> list = cart.getList();
                for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
                    chiTietHoaDonDAO.themChiTietHoaDon(new ChiTietHoaDon(ID, ds.getKey().getMa_san_pham(),
                            ds.getValue(), ds.getKey().getDon_gia(), ds.getKey().getGiamgia(),
                            ds.getValue() * ds.getKey().getDon_gia() - (ds.getValue() * ds.getKey().getDon_gia() * ds.getKey().getGiamgia()) / 100));
                     
                          
                    sanphamDAO.updateSanPham(new SanPham(ds.getKey().getMa_san_pham(),ds.getKey().getTen_san_pham(),ds.getKey().getMa_danh_muc()
                              , ds.getKey().getHinh_anh(),ds.getKey().getSo_luong()-ds.getValue(), 
                             ds.getKey().getDon_gia(),ds.getKey().getGiamgia(),ds.getKey().getMan_hinh(),ds.getKey().getCamera_sau(),ds.getKey().getCamera_truoc()
                              , ds.getKey().getHe_dieu_hanh(),ds.getKey().getCpu(), ds.getKey().getBo_nho(),ds.getKey().getRam(),ds.getKey().getKet_noi(),ds.getKey().getPin_sac(),ds.getKey().getBao_hanh(),ds.getKey().getMo_ta()));
                }
                cart = new GioHang();
                session.setAttribute("cart", cart);
            } catch (Exception e) {
            }
            response.sendRedirect("/MyProject/default.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
            rd.forward(request, response);
        }

    }
}
