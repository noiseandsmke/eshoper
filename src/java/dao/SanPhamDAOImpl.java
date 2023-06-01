/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietHoaDon;
import model.SanPham;

/**
 *
 * @author Nguyen
 */
public class SanPhamDAOImpl implements SanPhamDAO {

    @Override
    public ArrayList<SanPham> getListSanPhamTheoDanhMuc(int ma_danh_muc) {   //@@
        Connection connection = DBConnector.getConnection();
        String sql = "SELECT [ma_san_pham]\n" +
"      ,[ten_san_pham]\n" +
"      ,[ma_danh_muc]\n" +
"      ,[hinh_anh]\n" +
"      ,[so_luong]\n" +
"      ,[don_gia]\n" +
"      ,[giam_gia]\n" +
"      ,[man_hinh]\n" +
"      ,[camera_sau]\n" +
"      ,[camera_truoc]\n" +
"      ,[he_dieu_hanh]\n" +
"      ,[cpu]\n" +
"      ,[bo_nho]\n" +
"      ,[ram]\n" +
"      ,[ket_noi]\n" +
"      ,[pin_sac]\n" +
"      ,[mo_ta]\n" +
"  FROM [dbo].[san_pham]" ;
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham san_pham = new SanPham();

                san_pham.setMa_san_pham(rs.getInt("ma_san_pham"));
                san_pham.setTen_san_pham(rs.getString("ten_san_pham"));
                san_pham.setMa_danh_muc(rs.getInt("ma_danh_muc"));
                san_pham.setHinh_anh(rs.getString("hinh_anh"));
                san_pham.setSo_luong(rs.getInt("so_luong"));
                san_pham.setDon_gia(rs.getInt("don_gia"));
                san_pham.setGiamgia(rs.getInt("giam_gia"));
                san_pham.setMan_hinh(rs.getString("man_hinh"));
                san_pham.setCamera_sau(rs.getString("camera_sau"));
                san_pham.setCamera_truoc(rs.getString("camera_truoc"));
                san_pham.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                san_pham.setCpu(rs.getString("cpu"));
                san_pham.setBo_nho(rs.getString("bo_nho"));
                san_pham.setRam(rs.getString("ram"));
                san_pham.setKet_noi(rs.getString("ket_noi"));
                san_pham.setPin_sac(rs.getString("pin_sac"));
               // san_pham.setBao_hanh(rs.getString("bao_hanh"));
                san_pham.setMo_ta(rs.getString("mo_ta"));
                arr.add(san_pham);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public SanPham getChiTietSanPham(int ma_san_pham) {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from san_pham where ma_san_pham='" + ma_san_pham + "'";
        SanPham san_pham = new SanPham();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                san_pham.setMa_san_pham(rs.getInt("ma_san_pham"));
                san_pham.setTen_san_pham(rs.getString("ten_san_pham")); 

                san_pham.setMa_danh_muc(rs.getInt("ma_danh_muc"));

                san_pham.setHinh_anh(rs.getString("hinh_anh"));
                san_pham.setSo_luong(rs.getInt("so_luong"));
                san_pham.setDon_gia(rs.getInt("don_gia"));
                san_pham.setGiamgia(rs.getInt("giam_gia"));
                san_pham.setMan_hinh(rs.getString("man_hinh"));
                san_pham.setCamera_sau(rs.getString("camera_sau"));
                san_pham.setCamera_truoc(rs.getString("camera_truoc"));
                san_pham.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                san_pham.setCpu(rs.getString("cpu"));
                san_pham.setBo_nho(rs.getString("bo_nho"));
                san_pham.setRam(rs.getString("ram"));
                san_pham.setKet_noi(rs.getString("ket_noi"));
                san_pham.setPin_sac(rs.getString("pin_sac"));
//                san_pham.setBao_hanh(rs.getString("bao_hanh"));
                san_pham.setMo_ta(rs.getString("mo_ta"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return san_pham;

    }

    @Override
    public ArrayList<SanPham> getListSanPham(String ten_san_pham) {
        Connection connection = DBConnector.getConnection();
        String sql = "Select * from san_pham where ten_san_pham like '%" + ten_san_pham + "%'";
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTen_san_pham(rs.getString("ten_san_pham"));

                sp.setMa_danh_muc(rs.getInt("ma_danh_muc"));
                sp.setHinh_anh(rs.getString("hinh_anh"));
                sp.setSo_luong(rs.getInt("so_luong"));
                sp.setDon_gia(rs.getInt("don_gia"));
                sp.setGiamgia(rs.getInt("giam_gia"));
                sp.setMan_hinh(rs.getString("man_hinh"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                sp.setCpu(rs.getString("cpu"));
                sp.setBo_nho(rs.getString("bo_nho"));
                sp.setRam(rs.getString("ram"));
                sp.setKet_noi(rs.getString("ket_noi"));
                sp.setPin_sac(rs.getString("pin_sac"));
//                sp.setBao_hanh(rs.getString("bao_hanh"));
                sp.setMo_ta(rs.getString("mo_ta"));
                arr.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }

    @Override
    public ArrayList<SanPham> getListSanPhamMoi() {
        Connection connection = DBConnector.getConnection();
        String sql = "SELECT TOP 8 * FROM san_pham ORDER BY ma_san_pham DESC;";
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTen_san_pham(rs.getString("ten_san_pham"));

                sp.setMa_danh_muc(rs.getInt("ma_danh_muc"));
                sp.setHinh_anh(rs.getString("hinh_anh"));
                sp.setSo_luong(rs.getInt("so_luong"));
                sp.setDon_gia(rs.getInt("don_gia"));
                sp.setGiamgia(rs.getInt("giam_gia"));
                sp.setMan_hinh(rs.getString("man_hinh"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                sp.setCpu(rs.getString("cpu"));
                sp.setBo_nho(rs.getString("bo_nho"));
                sp.setRam(rs.getString("ram"));
                sp.setKet_noi(rs.getString("ket_noi"));
                sp.setPin_sac(rs.getString("pin_sac"));
//                sp.setBao_hanh(rs.getString("bao_hanh"));
                sp.setMo_ta(rs.getString("mo_ta"));
                arr.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public ArrayList<SanPham> getListSanPhamTheoGia(int a, int b) {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from san_pham where don_gia>='" + a + "'and don_gia <'" + b + "'";
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham san_pham = new SanPham();

                san_pham.setMa_san_pham(rs.getInt("ma_san_pham"));
                san_pham.setTen_san_pham(rs.getString("ten_san_pham"));

                san_pham.setMa_danh_muc(rs.getInt("ma_danh_muc"));

                san_pham.setHinh_anh(rs.getString("hinh_anh"));
                san_pham.setSo_luong(rs.getInt("so_luong"));
                san_pham.setDon_gia(rs.getInt("don_gia"));
                san_pham.setGiamgia(rs.getInt("giam_gia"));
                san_pham.setMan_hinh(rs.getString("man_hinh"));
                san_pham.setCamera_sau(rs.getString("camera_sau"));
                san_pham.setCamera_truoc(rs.getString("camera_truoc"));
                san_pham.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                san_pham.setCpu(rs.getString("cpu"));
                san_pham.setBo_nho(rs.getString("bo_nho"));
                san_pham.setRam(rs.getString("ram"));
                san_pham.setKet_noi(rs.getString("ket_noi"));
                san_pham.setPin_sac(rs.getString("pin_sac"));
//                san_pham.setBao_hanh(rs.getString("bao_hanh"));
                san_pham.setMo_ta(rs.getString("mo_ta"));
                arr.add(san_pham);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public ArrayList<SanPham> getListSanPham() {
          ArrayList<SanPham> arr = new ArrayList<>();
    
    try (Connection connection = DBConnector.getConnection();
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM san_pham");
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            SanPham sp = new SanPham();
            sp.setMa_san_pham(rs.getInt("ma_san_pham"));
            sp.setTen_san_pham(rs.getString("ten_san_pham"));
            sp.setMa_danh_muc(rs.getInt("ma_danh_muc"));
            sp.setHinh_anh(rs.getString("hinh_anh"));
            sp.setSo_luong(rs.getInt("so_luong"));
            sp.setDon_gia(rs.getInt("don_gia"));
            sp.setGiamgia(rs.getInt("giam_gia"));
            sp.setMan_hinh(rs.getString("man_hinh"));
            sp.setCamera_sau(rs.getString("camera_sau"));
            sp.setCamera_truoc(rs.getString("camera_truoc"));
            sp.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
            sp.setCpu(rs.getString("cpu"));
            sp.setBo_nho(rs.getString("bo_nho"));
            sp.setRam(rs.getString("ram"));
            sp.setKet_noi(rs.getString("ket_noi"));
            sp.setPin_sac(rs.getString("pin_sac"));
            //sp.setBao_hanh(rs.getString("bao_hanh"));
            sp.setMo_ta(rs.getString("mo_ta"));
            arr.add(sp);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public boolean insertSanPham(SanPham sanpham) {
        Connection connection = DBConnector.getConnection();
        String sql = "INSERT INTO san_pham VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, sanpham.getTen_san_pham());
            ps.setInt(2, sanpham.getMa_danh_muc());
            ps.setString(3, sanpham.getHinh_anh());
            ps.setInt(4, sanpham.getSo_luong());
            ps.setInt(5, sanpham.getDon_gia());
            ps.setInt(6, sanpham.getGiamgia());
            ps.setString(7, sanpham.getMan_hinh());
            ps.setString(8, sanpham.getCamera_sau());
            ps.setString(9, sanpham.getCamera_truoc());
            ps.setString(10, sanpham.getHe_dieu_hanh());
            ps.setString(11, sanpham.getCpu());
            ps.setString(12, sanpham.getBo_nho());
            ps.setString(13, sanpham.getRam());
            ps.setString(14, sanpham.getKet_noi());
            ps.setString(15, sanpham.getPin_sac());
      //      ps.setString(16, sanpham.getBao_hanh());
            ps.setString(16, sanpham.getMo_ta());

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteSanPham(int ma_san_pham) {
        try {
            Connection connection = DBConnector.getConnection();
            String sql = "delete from san_pham where ma_san_pham=?";

            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ma_san_pham);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateSanPham(SanPham sanpham) {
        Connection connection = DBConnector.getConnection();
        String sql = "UPDATE san_pham SET ten_san_pham=?,ma_danh_muc=?,hinh_anh=?,so_luong=?,"
                + " don_gia=?,giam_gia=?,man_hinh=?,camera_sau=?,camera_truoc=?,he_dieu_hanh=?,"
                + "cpu=?,bo_nho=?,ram=?,ket_noi=?,pin_sac=?,mo_ta=? where ma_san_pham=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, sanpham.getTen_san_pham());
            ps.setInt(2, sanpham.getMa_danh_muc());
            ps.setString(3, sanpham.getHinh_anh());
            ps.setInt(4, sanpham.getSo_luong());
            ps.setInt(5, sanpham.getDon_gia());
            ps.setInt(6, sanpham.getGiamgia());
            ps.setString(7, sanpham.getMan_hinh());
            ps.setString(8, sanpham.getCamera_sau());
            ps.setString(9, sanpham.getCamera_truoc());
            ps.setString(10, sanpham.getHe_dieu_hanh());
            ps.setString(11, sanpham.getCpu());
            ps.setString(12, sanpham.getBo_nho());
            ps.setString(13, sanpham.getRam());
            ps.setString(14, sanpham.getKet_noi());
            ps.setString(15, sanpham.getPin_sac());
   //         ps.setString(16, sanpham.getBao_hanh());
            ps.setString(16, sanpham.getMo_ta());
            ps.setInt(17, sanpham.getMa_san_pham());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<SanPham> getListSanPhamTheo(ArrayList<SanPham> arr, int start, int end) {
        ArrayList<SanPham> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> getListSanPhamBanChay() {
        Connection connection = DBConnector.getConnection();
        String sql = "select top 5 sp.ma_san_pham,sp.ten_san_pham,cthd.so_luong from san_pham sp,chi_tiet_hoa_don cthd where sp.ma_san_pham=cthd.ma_san_pham;";
        ArrayList<SanPham> arr = new ArrayList<>();
        try {

            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTen_san_pham(rs.getString("ten_san_pham"));

                sp.setSo_luong(rs.getInt("so_luong"));

                arr.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public static void main(String[] args) {
        SanPhamDAOImpl spdao = new SanPhamDAOImpl();
        for (SanPham sp : spdao.getListSanPhamBanChay()) {
            System.out.println(sp.getMa_san_pham() + "-" + sp.getTen_san_pham() + "-" + sp.getSo_luong());
        }

    }

    @Override
    public boolean deleteSanPhamTheoMaDanhMuc(int ma_danh_muc) {
        Connection connection = DBConnector.getConnection();
        String sql = "delete from san_pham Where ma_danh_muc=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ma_danh_muc);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<SanPham> getListSanPhamByPrice(String minPrice, String maxPrice) {
        Connection connection = DBConnector.getConnection();
        String sql = "Select * from san_pham where don_gia <= " + minPrice + " and don_gia => "+ maxPrice;
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTen_san_pham(rs.getString("ten_san_pham"));

                sp.setMa_danh_muc(rs.getInt("ma_danh_muc"));
                sp.setHinh_anh(rs.getString("hinh_anh"));
                sp.setSo_luong(rs.getInt("so_luong"));
                sp.setDon_gia(rs.getInt("don_gia"));
                sp.setGiamgia(rs.getInt("giam_gia"));
                sp.setMan_hinh(rs.getString("man_hinh"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setHe_dieu_hanh(rs.getString("he_dieu_hanh"));
                sp.setCpu(rs.getString("cpu"));
                sp.setBo_nho(rs.getString("bo_nho"));
                sp.setRam(rs.getString("ram"));
                sp.setKet_noi(rs.getString("ket_noi"));
                sp.setPin_sac(rs.getString("pin_sac"));
//                sp.setBao_hanh(rs.getString("bao_hanh"));
                sp.setMo_ta(rs.getString("mo_ta"));
                arr.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
