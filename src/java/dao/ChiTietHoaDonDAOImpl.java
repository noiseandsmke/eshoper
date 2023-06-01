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

/**
 *
 * @author Nguyen
 */
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

    @Override
    public void themChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException {
        Connection connection = DBConnector.getConnection();
     
        String sql="INSERT INTO chi_tiet_hoa_don values(?,?,?,?,?,?,?)";
        PreparedStatement ps =connection.prepareCall(sql);
       // ps.setInt(1,db.getBilldetail_id());
        ps.setInt(1,cthd.getMa_hoa_don());
        ps.setInt(2,cthd.getMa_san_pham());
        ps.setFloat(3,cthd.getSo_luong());
        ps.setInt(4, cthd.getDon_gia());
        ps.setInt(5, cthd.getGiam_gia());
        ps.setInt(6, cthd.getThanh_tien());
        ps.setInt(7, cthd.getMa_chi_tiet_hoa_don());       //@@
        ps.executeUpdate();
    }
    public static void main(String[] args) throws SQLException {
        ChiTietHoaDonDAOImpl cthdDAO= new ChiTietHoaDonDAOImpl();
        cthdDAO.themChiTietHoaDon(new ChiTietHoaDon(1, 1, 1, 1, 1, 1));
        System.out.println("them chi tiet hoa dont  thanh cong !");
    }

    @Override
    public ArrayList<ChiTietHoaDon> getListChiTietHoaDonTheoMaHoaDon(int ma_hoa_don) {
     Connection connection=DBConnector.getConnection();
     String sql="select * from chi_tiet_hoa_don where ma_hoa_don='"+ma_hoa_don+"'";
        ArrayList<ChiTietHoaDon> arr= new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ChiTietHoaDon cthd= new ChiTietHoaDon();
                cthd.setMa_chi_tiet_hoa_don(rs.getInt("ma_chi_tiet_hoa_don"));
                cthd.setMa_hoa_don(rs.getInt("ma_hoa_don"));
                cthd.setMa_san_pham(rs.getInt("ma_san_pham"));
                cthd.setSo_luong(rs.getInt("so_luong"));
                cthd.setDon_gia(rs.getInt("don_gia"));
                cthd.setGiam_gia(rs.getInt("giam_gia"));
                cthd.setThanh_tien(rs.getInt("thanh_tien"));
                arr.add(cthd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
