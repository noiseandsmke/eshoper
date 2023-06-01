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
import model.LoaiTin;


/**
 *
 * @author Nguyen
 */
public class LoaiTinDAOImpl implements LoaiTinDAO{
   

    @Override
    public ArrayList<LoaiTin> getListLoaiTin() {
       Connection connection=DBConnector.getConnection();
       String sql="Select * from loai_tin";
       ArrayList<LoaiTin> list=new ArrayList<>();
        try {
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                LoaiTin loaiTin=new LoaiTin();
                loaiTin.setMa_loai_tin(rs.getInt("ma_loai_tin"));
                loaiTin.setTen_loai_tin(rs.getString("ten_loai_tin"));
                list.add(loaiTin);
                
            }
            connection.close();
                   
        } catch (SQLException ex) {
            Logger.getLogger(LoaiTinDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
               
    }
    public static void main(String[] args) {
        LoaiTinDAOImpl loaiTinDAOImpl = new LoaiTinDAOImpl();
         for(LoaiTin lt: loaiTinDAOImpl.getListLoaiTin())
         {
             System.out.println(lt.getTen_loai_tin());
         }
    }

    @Override
    public boolean insertLoaiTin(LoaiTin loaitin) {
       Connection connection=DBConnector.getConnection();
        String sql="INSERT INTO loai_tin VALUES(?)";
        try {
            PreparedStatement ps=connection.prepareCall(sql);
           
            ps.setString(1,loaitin.getTen_loai_tin());
       
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
               
    }

    @Override
    public boolean updateLoaiTin(LoaiTin loaitin) {
        Connection connection=DBConnector.getConnection();
        String sql="UPDATE loai_tin SET ten_loai_tin=? where ma_loai_tin=?";
        try {
            PreparedStatement ps=connection.prepareCall(sql);
            
            ps.setString(1,loaitin.getTen_loai_tin());
    
             ps.setInt(2,loaitin.getMa_loai_tin());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  false;
    }

    @Override
    public boolean deleteLoaiTin(int ma_loai_tin) {
        try {
            Connection connection=DBConnector.getConnection();
            String sql="delete from loai_tin where ma_loai_tin=?";
            
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1,ma_loai_tin);
            return ps.executeUpdate()==1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public LoaiTin getLoaiTin(int ma_loai_tin) {
         try {
            Connection connection=DBConnector.getConnection();
            String sql="SELECT * FROM loai_tin WHERE ma_loai_tin=?";
            PreparedStatement ps=connection.prepareCall(sql);
            ps.setInt(1,ma_loai_tin);
            
            ResultSet rs=ps.executeQuery();
           
           
           LoaiTin loaitin= new LoaiTin();
            while(rs.next())
            {
                loaitin.setTen_loai_tin(rs.getString("ten_loai_tin"));
            
               
            }
            return loaitin;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<LoaiTin> getListLoaiTinTheoTrang(ArrayList<LoaiTin> arr, int start, int end) {
         ArrayList<LoaiTin> list= new ArrayList<>();
       for(int i=start;i<end;i++)
       {
           list.add(arr.get(i));
       }
       return list;
    }
    
}
