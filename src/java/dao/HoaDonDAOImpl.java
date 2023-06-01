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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author Nguyen
 */
public class HoaDonDAOImpl implements HoaDonDAO {
    
    @Override
    public void themHoaDon(HoaDon hd) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try {
          String sql = "INSERT INTO hoa_don VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, hd.getMa_hoa_don());
        ps.setInt(2, hd.getMa_tai_khoan());
        ps.setFloat(3, hd.getTong_tien());
        ps.setString(4, hd.getDia_chi_giao_hang());
//        ps.setString(5, hd.getSo_dien_thoai());
        ps.setString(5, hd.getPhuong_thuc_thanh_toan());
        ps.setString(6, hd.getNgay_mua_hang());
        ps.setInt(7, hd.getTinh_trang_don_hang());
        
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("lỗi sml: "+e);
        }
 

        
    }
    
    @Override
    public ArrayList<HoaDon> getListHoaDon() {
        Connection connection = DBConnector.getConnection();
        String sql = "Select * from hoa_don";
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMa_hoa_don(rs.getInt("ma_hoa_don"));
                hd.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                hd.setTong_tien(rs.getFloat("tong_tien"));
                hd.setDia_chi_giao_hang(rs.getString("dia_chi_giao_hang"));
//                hd.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hd.setPhuong_thuc_thanh_toan(rs.getString("phuong_thuc_thanh_toan"));
                hd.setNgay_mua_hang(rs.getString("ngay_mua_hang"));
                hd.setTinh_trang_don_hang(rs.getInt("tinh_trang_don_hang"));
                
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public ArrayList<HoaDon> getListHoaDonTheoTrang(ArrayList<HoaDon> arr, int start, int end) {
        ArrayList<HoaDon> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
    
    @Override
    public HoaDon getHoaDon(int ma_hoa_don) {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from hoa_don where ma_hoa_don='" + ma_hoa_don + "'";
        HoaDon hd = new HoaDon();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd.setMa_hoa_don(rs.getInt("ma_hoa_don"));
                hd.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                hd.setTong_tien(rs.getFloat("tong_tien"));
                hd.setDia_chi_giao_hang(rs.getString("dia_chi_giao_hang"));
                hd.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hd.setPhuong_thuc_thanh_toan(rs.getString("phuong_thuc_thanh_toan"));
                hd.setNgay_mua_hang(rs.getString("ngay_mua_hang"));
                hd.setTinh_trang_don_hang(rs.getInt("tinh_trang_don_hang"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hd;
    }
    
    public static void main(String[] args) throws SQLException {
        HoaDonDAOImpl hd = new HoaDonDAOImpl();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String date = dateFormat.format(new Date());
//           hd.themHoaDon(new HoaDon(1,1, 1000, "date", "date",date,0));
//        System.out.println("Them hoa don thanh cong");
//        
        System.out.println(hd.getHoaDon(469172643).getMa_hoa_don() + "-" + hd.getHoaDon(469172643).getTong_tien());
    }
    
    @Override
    public boolean updateHoaDon(HoaDon hoadon) {
        Connection connection = DBConnector.getConnection();
        String sql = "UPDATE hoa_don set ma_tai_khoan=?,tong_tien=?,dia_chi_giao_hang=?,so_dien_thoai=?,phuong_thuc_thanh_toan=?,"
                + "ngay_mua_hang=?,tinh_trang_don_hang=? where ma_hoa_don=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, hoadon.getMa_tai_khoan());
            ps.setFloat(2, hoadon.getTong_tien());
            ps.setString(3, hoadon.getDia_chi_giao_hang());
            ps.setString(4, hoadon.getPhuong_thuc_thanh_toan());
            ps.setString(5, hoadon.getNgay_mua_hang());
            ps.setInt(6, hoadon.getTinh_trang_don_hang());
            ps.setInt(7, hoadon.getMa_hoa_don());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
