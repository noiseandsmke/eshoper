/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.HoaDon;

/**
 *
 * @author Nguyen
 */
public interface HoaDonDAO {

    public void themHoaDon(HoaDon hd) throws SQLException;

    public ArrayList<HoaDon> getListHoaDon();

    public ArrayList<HoaDon> getListHoaDonTheoTrang(ArrayList<HoaDon> arr, int start, int end);

    public HoaDon getHoaDon(int ma_hoa_don);

    public boolean updateHoaDon(HoaDon hoadon);

   
}
