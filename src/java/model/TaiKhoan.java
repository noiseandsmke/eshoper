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
public class TaiKhoan {

    private int ma_tai_khoan;
    private String ten_tai_khoan;
    private String ten_dang_nhap;
    private String mat_khau;
    private int quyen_truy_cap;
    
    public TaiKhoan() {
    }

    public TaiKhoan(String ten_tai_khoan, String ten_dang_nhap, String mat_khau, int quyen_truy_cap) {
        this.ten_tai_khoan = ten_tai_khoan;
        this.ten_dang_nhap = ten_dang_nhap;
        this.mat_khau = mat_khau;
        this.quyen_truy_cap = quyen_truy_cap;

    }

    public TaiKhoan(int ma_tai_khoan, String ten_tai_khoan, String ten_dang_nhap, String mat_khau, int quyen_truy_cap) {
        this.ma_tai_khoan = ma_tai_khoan;
        this.ten_tai_khoan = ten_tai_khoan;
        this.ten_dang_nhap = ten_dang_nhap;
        this.mat_khau = mat_khau;
        this.quyen_truy_cap = quyen_truy_cap;

    }

    public int getMa_tai_khoan() {
        return ma_tai_khoan;
    }

    public void setMa_tai_khoan(int ma_tai_khoan) {
        this.ma_tai_khoan = ma_tai_khoan;
    }

    public String getTen_tai_khoan() {
        return ten_tai_khoan;
    }

    public void setTen_tai_khoan(String ten_tai_khoan) {
        this.ten_tai_khoan = ten_tai_khoan;
    }

    public String getTen_dang_nhap() {
        return ten_dang_nhap;
    }

    public void setTen_dang_nhap(String ten_dang_nhap) {
        this.ten_dang_nhap = ten_dang_nhap;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public int getQuyen_truy_cap() {
        return quyen_truy_cap;
    }

    public void setQuyen_truy_cap(int quyen_truy_cap) {
        this.quyen_truy_cap = quyen_truy_cap;
    }

}
