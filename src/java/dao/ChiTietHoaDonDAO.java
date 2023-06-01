/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietHoaDon;

/**
 *
 * @author Nguyen
 */
public interface ChiTietHoaDonDAO {
    public void themChiTietHoaDon(ChiTietHoaDon cthd)  throws SQLException;
    public ArrayList<ChiTietHoaDon> getListChiTietHoaDonTheoMaHoaDon(int ma_hoa_don);

    
}
