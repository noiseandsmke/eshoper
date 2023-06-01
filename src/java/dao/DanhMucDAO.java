/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.DanhMuc;

/**
 *
 * @author Nguyen
 */
public interface DanhMucDAO {

   

    // load tat ca cac danh muc
    ArrayList<DanhMuc> getListDanhMuc();
    // load dnah muc dua vao ma dnah muc
    DanhMuc getDanhMuc(int ma_Danh_muc);
    // insert danh muc
    boolean insertDanhMuc(DanhMuc danhmuc);
    boolean updateDanhMuc(DanhMuc danhmuc);
    boolean deleteDanhMuc(int ma_danh_muc);
     public ArrayList<DanhMuc> getListDanhMucTheoTrang(ArrayList<DanhMuc> arr, int start, int end);
  
}
