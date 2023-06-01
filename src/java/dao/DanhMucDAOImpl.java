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
import model.DanhMuc;

/**
 *
 * @author Nguyen
 */
public class DanhMucDAOImpl implements DanhMucDAO {
   

    @Override
    
    public ArrayList<DanhMuc> getListDanhMuc() {
        Connection connection = DBConnector.getConnection();
        String sql = "select * from danh_muc";
        ArrayList<DanhMuc> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                 DanhMuc dm = new DanhMuc();
                dm.setMa_danh_muc(rs.getInt("ma_danh_muc"));
                dm.setTen_danh_muc(rs.getString("ten_Danh_muc"));
                arr.add(dm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }
   
    @Override
    public boolean insertDanhMuc(DanhMuc danhmuc) {
        Connection connection=DBConnector.getConnection();
        String sql="INSERT INTO danh_muc VALUES(?)";
        try {
            PreparedStatement ps=connection.prepareCall(sql);
           
            ps.setString(1,danhmuc.getTen_danh_muc());
           
            
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  false;
    }

    @Override
    public boolean updateDanhMuc(DanhMuc danhmuc) {
       Connection connection=DBConnector.getConnection();
        String sql="UPDATE danh_muc SET ten_danh_muc=? where ma_danh_muc=?";
        try {
            PreparedStatement ps=connection.prepareCall(sql);
            
            ps.setString(1,danhmuc.getTen_danh_muc());
    
             ps.setInt(2,danhmuc.getMa_danh_muc());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  false;
    }

    @Override
    public boolean deleteDanhMuc(int ma_danh_muc) {
        try {
            Connection connection=DBConnector.getConnection();
            String sql="delete from danh_muc where ma_danh_muc=?";
            
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1,ma_danh_muc);
            return ps.executeUpdate()==1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public DanhMuc getDanhMuc(int ma_Danh_muc) {
       try {
            Connection connection=DBConnector.getConnection();
            String sql="SELECT * FROM danh_muc WHERE ma_danh_muc=?";
            PreparedStatement ps=connection.prepareCall(sql);
            ps.setInt(1,ma_Danh_muc);
            
            ResultSet rs=ps.executeQuery();
           
           DanhMuc dm= new DanhMuc();
            while(rs.next())
            {
              dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
               
            }
            return dm;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public ArrayList<DanhMuc> getListDanhMucTheoTrang(ArrayList<DanhMuc> arr, int start, int end) {
        ArrayList<DanhMuc> list= new ArrayList<>();
       for(int i=start;i<end;i++)
       {
           list.add(arr.get(i));
       }
       return list;
    }
  
  
    
}
