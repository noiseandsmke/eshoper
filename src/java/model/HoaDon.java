/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Nguyen
 */
public class HoaDon {

    private int ma_hoa_don;
    private int ma_tai_khoan;
    private float tong_tien;
    private String dia_chi_giao_hang;
    private String so_dien_thoai;
    private String phuong_thuc_thanh_toan;
    private String ngay_mua_hang;
    private int tinh_trang_don_hang;

    public HoaDon() {
    }

    public HoaDon(int ma_tai_khoan, float tong_tien, String dia_chi_giao_hang, String phuong_thuc_thanh_toan, String ngay_mua_hang, int tinh_trang_don_hang) {
        this.ma_tai_khoan = ma_tai_khoan;
        this.tong_tien = tong_tien;
        this.dia_chi_giao_hang = dia_chi_giao_hang;
        this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
        this.ngay_mua_hang = ngay_mua_hang;
        this.tinh_trang_don_hang = tinh_trang_don_hang;
    }

    public HoaDon(int ma_hoa_don, int ma_tai_khoan, float tong_tien, String dia_chi_giao_hang, String phuong_thuc_thanh_toan, String ngay_mua_hang, int tinh_trang_don_hang) {
        this.ma_hoa_don = ma_hoa_don;
        this.ma_tai_khoan = ma_tai_khoan;
        this.tong_tien = tong_tien;
        this.dia_chi_giao_hang = dia_chi_giao_hang;
        this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
        this.ngay_mua_hang = ngay_mua_hang;
        this.tinh_trang_don_hang = tinh_trang_don_hang;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public HoaDon(int ma_hoa_don, int ma_tai_khoan, float tong_tien, String dia_chi_giao_hang, String so_dien_thoai, String phuong_thuc_thanh_toan, String ngay_mua_hang, int tinh_trang_don_hang) {
        this.ma_hoa_don = ma_hoa_don;
        this.ma_tai_khoan = ma_tai_khoan;
        this.tong_tien = tong_tien;
        this.dia_chi_giao_hang = dia_chi_giao_hang;
        this.so_dien_thoai = so_dien_thoai;
        this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
        this.ngay_mua_hang = ngay_mua_hang;
        this.tinh_trang_don_hang = tinh_trang_don_hang;
    }

    public int getMa_hoa_don() {
        return ma_hoa_don;
    }

    public void setMa_hoa_don(int ma_hoa_don) {
        this.ma_hoa_don = ma_hoa_don;
    }

    public int getMa_tai_khoan() {
        return ma_tai_khoan;
    }

    public void setMa_tai_khoan(int ma_tai_khoan) {
        this.ma_tai_khoan = ma_tai_khoan;
    }

    public float getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(float tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getDia_chi_giao_hang() {
        return dia_chi_giao_hang;
    }

    public void setDia_chi_giao_hang(String dia_chi_giao_hang) {
        this.dia_chi_giao_hang = dia_chi_giao_hang;
    }

    public String getPhuong_thuc_thanh_toan() {
        return phuong_thuc_thanh_toan;
    }

    public void setPhuong_thuc_thanh_toan(String phuong_thuc_thanh_toan) {
        this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
    }

    public String getNgay_mua_hang() {
        return ngay_mua_hang;
    }

    public void setNgay_mua_hang(String ngay_mua_hang) {
        this.ngay_mua_hang = ngay_mua_hang;
    }

    public int getTinh_trang_don_hang() {
        return tinh_trang_don_hang;
    }

    public void setTinh_trang_don_hang(int tinh_trang_don_hang) {
        this.tinh_trang_don_hang = tinh_trang_don_hang;
    }

}
