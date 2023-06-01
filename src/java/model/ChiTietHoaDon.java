/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nguyen
 */
public class ChiTietHoaDon {

    private int ma_chi_tiet_hoa_don = 0;
    private int ma_hoa_don;
    private int ma_san_pham;
    private int so_luong;
    private int don_gia;
    private int giam_gia;
    private int thanh_tien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int ma_hoa_don, int ma_san_pham, int so_luong, int don_gia, int giam_gia, int thanh_tien) {
        this.ma_hoa_don = ma_hoa_don;
        this.ma_san_pham = ma_san_pham;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
        this.giam_gia = giam_gia;
        this.thanh_tien = thanh_tien;
        this.ma_chi_tiet_hoa_don = this.ma_chi_tiet_hoa_don++; //@@
    }

    public int getMa_chi_tiet_hoa_don() {
        return ma_chi_tiet_hoa_don;
    }

    public void setMa_chi_tiet_hoa_don(int ma_chi_tiet_hoa_don) {
        this.ma_chi_tiet_hoa_don = ma_chi_tiet_hoa_don;
    }

    public int getMa_hoa_don() {
        return ma_hoa_don;
    }

    public void setMa_hoa_don(int ma_hoa_don) {
        this.ma_hoa_don = ma_hoa_don;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public int getGiam_gia() {
        return giam_gia;
    }

    public void setGiam_gia(int giam_gia) {
        this.giam_gia = giam_gia;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

   
}
