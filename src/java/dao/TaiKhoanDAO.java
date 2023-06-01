/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.TaiKhoan;



public interface TaiKhoanDAO {
    //lay danh sach tai khoan
    public ArrayList<TaiKhoan> getListTaiKhoan();
    // kiem tra tai khoan xem da ton tai chua
    public boolean  kiemTraTaiKhoan(String ten_dang_nhap);
    // them tai khoan moi
    public void themTaiKhoan(TaiKhoan tk);
    //kiem tra dang nhap.
    public boolean  kiemTraDangNhap(String ten_dang_nhap, String mat_khau);
    // 
    public TaiKhoan getTaiKhoan(String ten_dang_nhap);
    // lay thong tin tai khan theo ma
    public TaiKhoan getTaiKhoanTheoMa(int ma_tai_khoan);
    // delete tai khoan
    public boolean deleteTaiKhoan(int ma_tai_khoan);
    //update tai khoan
    public boolean updateTaiKhoan(TaiKhoan taikhoan);
    public ArrayList<TaiKhoan> getListTaiKhoanTheoTrang(ArrayList<TaiKhoan> arr, int start, int end);

    

    
}
