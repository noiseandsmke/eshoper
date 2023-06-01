/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author Nguyen
 */
public interface SanPhamDAO {
    //load san pham theo ma_danh_muc;
    public ArrayList<SanPham> getListSanPhamTheoDanhMuc(int ma_danh_muc);
    //hiển thị chi tiết sản phẩm
    public SanPham getChiTietSanPham(int ma_san_pham);
    // lay thong tin san pham theo ten san pham
    public ArrayList<SanPham> getListSanPham(String ten_san_pham);
    // lay danh sach san pham moi nhat
    public ArrayList<SanPham> getListSanPhamMoi();
    // Lay danh sach san pham theo gia
    public ArrayList<SanPham> getListSanPhamTheoGia(int a, int b);
    // Lay tât ca danh sach san pham
    public ArrayList<SanPham> getListSanPham();
    public ArrayList<SanPham> getListSanPhamByPrice(String price1, String price2);
    //PHAN TRANG
    public ArrayList<SanPham> getListSanPhamTheo(ArrayList<SanPham> arr, int start, int end);
    boolean insertSanPham(SanPham sanpham);
    boolean deleteSanPham(int ma_san_pham);
    boolean updateSanPham(SanPham sanpham);
    boolean deleteSanPhamTheoMaDanhMuc(int ma_danh_muc);
    //thong ke san pham ban chay
    public ArrayList<SanPham> getListSanPhamBanChay();
}
