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
import model.TaiKhoan;


public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public boolean kiemTraTaiKhoan(String ten_dang_nhap) {
        Connection connection = DBConnector.getConnection();
        String sql = "select ten_dang_nhap from tai_khoan where ten_dang_nhap='" + ten_dang_nhap + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public void themTaiKhoan(TaiKhoan tk) {
        Connection connection = DBConnector.getConnection();
        String sql = "INSERT INTO tai_khoan VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, tk.getTen_tai_khoan());
            ps.setString(2, tk.getTen_dang_nhap());
            ps.setString(3, tk.getMat_khau());
            ps.setInt(4, tk.getQuyen_truy_cap());
            ps.setBoolean(5, true);

            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean kiemTraDangNhap(String ten_dang_nhap, String mat_khau) {
        Connection connection = DBConnector.getConnection();// '-- delete table account;
        String sql = "select * from tai_khoan where ten_dang_nhap='" + ten_dang_nhap + "'and mat_khau='" + mat_khau + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public TaiKhoan getTaiKhoan(String ten_dang_nhap) {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from tai_khoan where ten_dang_nhap='" + ten_dang_nhap + "'";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public TaiKhoan getTaiKhoanTheoMa(int ma_tai_khoan) {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from tai_khoan where ma_tai_khoan='" + ma_tai_khoan + "'";
        TaiKhoan tk = new TaiKhoan();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                tk.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
                tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
                tk.setMat_khau(rs.getString("mat_khau"));
                tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;

    }

    @Override
    public ArrayList<TaiKhoan> getListTaiKhoan() {
        Connection connection = DBConnector.getConnection();
        String sql = "Select * from tai_khoan";
        ArrayList<TaiKhoan> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                tk.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
                tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
                tk.setMat_khau(rs.getString("mat_khau"));
                tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
                
                arr.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public boolean deleteTaiKhoan(int ma_tai_khoan) {
        try {
            Connection connection = DBConnector.getConnection();
            String sql = "delete from tai_khoan where ma_tai_khoan=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ma_tai_khoan);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateTaiKhoan(TaiKhoan taikhoan) {
        Connection connection = DBConnector.getConnection();
        String sql = "UPDATE tai_khoan SET ten_tai_khoan=?,"
                + "ten_dang_nhap=?,mat_khau=?,quyen_truy_cap=? where ma_tai_khoan=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, taikhoan.getTen_tai_khoan());
            ps.setString(2, taikhoan.getTen_dang_nhap());
            ps.setString(3, taikhoan.getMat_khau());
            ps.setInt(4, taikhoan.getQuyen_truy_cap());
            ps.setInt(5, taikhoan.getMa_tai_khoan());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        TaiKhoanDAOImpl tkdao = new TaiKhoanDAOImpl();
        // System.out.println(tkdao.getTaiKhoan("anhduoc2705@gmail.com").getMa_tai_khoan());
        //tkdao.themTaiKhoan(new TaiKhoan("ten_tai_khoan", "ten_dang_nhap", "mat_khau", 0, 0));
        // System.out.println(tkdao.getTaiKhoanTheoMa(1).getTen_dang_nhap());
        //tkdao.updateTaiKhoan(new TaiKhoan("ten_tai_khoan", "ten_dang_nhap", "mat_khau", 0, 0));
        // tkdao.updateTaiKhoan(new TaiKhoan(1, "ten_tai_khoan", "anhduoc2705195@gmail.com", "e99a18c428cb38d5f260853678922e03", 1, 1));
        System.out.println(tkdao.getTaiKhoan("anhduoc2705195@gmail.com").getQuyen_truy_cap());
    }

    @Override
    public ArrayList<TaiKhoan> getListTaiKhoanTheoTrang(ArrayList<TaiKhoan> arr, int start, int end) {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

}
