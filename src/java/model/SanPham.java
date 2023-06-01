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
public class SanPham implements Comparable<SanPham>{
    private int ma_san_pham;
    private String ten_san_pham;
    private int ma_danh_muc;
    private String hinh_anh;
    private int so_luong;
    private int don_gia;
    private int giamgia;
    private String man_hinh;
    private String camera_sau;
    private String camera_truoc;
    private String he_dieu_hanh;
    private String cpu;
    private String bo_nho;
    private String ram;
    private String ket_noi;
    private String pin_sac;
    private String bao_hanh;
    private String mo_ta;

    public SanPham() {
    }

    public SanPham(String ten_san_pham, int ma_danh_muc, String hinh_anh, int so_luong, int don_gia, int giamgia, String man_hinh, String camera_sau, String camera_truoc, String he_dieu_hanh, String cpu, String bo_nho, String ram, String ket_noi, String pin_sac, String bao_hanh, String mo_ta) {
        this.ten_san_pham = ten_san_pham;
        this.ma_danh_muc = ma_danh_muc;
        this.hinh_anh = hinh_anh;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
        this.giamgia = giamgia;
        this.man_hinh = man_hinh;
        this.camera_sau = camera_sau;
        this.camera_truoc = camera_truoc;
        this.he_dieu_hanh = he_dieu_hanh;
        this.cpu = cpu;
        this.bo_nho = bo_nho;
        this.ram = ram;
        this.ket_noi = ket_noi;
        this.pin_sac = pin_sac;
        this.bao_hanh = bao_hanh;
        this.mo_ta = mo_ta;
    }

    public SanPham(int ma_san_pham, String ten_san_pham, int ma_danh_muc, String hinh_anh, int so_luong, int don_gia, int giamgia, String man_hinh, String camera_sau, String camera_truoc, String he_dieu_hanh, String cpu, String bo_nho, String ram, String ket_noi, String pin_sac, String bao_hanh, String mo_ta) {
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.ma_danh_muc = ma_danh_muc;
        this.hinh_anh = hinh_anh;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
        this.giamgia = giamgia;
        this.man_hinh = man_hinh;
        this.camera_sau = camera_sau;
        this.camera_truoc = camera_truoc;
        this.he_dieu_hanh = he_dieu_hanh;
        this.cpu = cpu;
        this.bo_nho = bo_nho;
        this.ram = ram;
        this.ket_noi = ket_noi;
        this.pin_sac = pin_sac;
        this.bao_hanh = bao_hanh;
        this.mo_ta = mo_ta;
    }

    

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public int getMa_danh_muc() {
        return ma_danh_muc;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public String getMan_hinh() {
        return man_hinh;
    }

    public String getCamera_sau() {
        return camera_sau;
    }

    public String getCamera_truoc() {
        return camera_truoc;
    }

    public String getHe_dieu_hanh() {
        return he_dieu_hanh;
    }

    public String getCpu() {
        return cpu;
    }

    public String getBo_nho() {
        return bo_nho;
    }

    public String getRam() {
        return ram;
    }

    public String getKet_noi() {
        return ket_noi;
    }

    public String getPin_sac() {
        return pin_sac;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public void setMa_danh_muc(int ma_danh_muc) {
        this.ma_danh_muc = ma_danh_muc;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public void setMan_hinh(String man_hinh) {
        this.man_hinh = man_hinh;
    }

    public void setCamera_sau(String camera_sau) {
        this.camera_sau = camera_sau;
    }

    public void setCamera_truoc(String camera_truoc) {
        this.camera_truoc = camera_truoc;
    }

    public void setHe_dieu_hanh(String he_dieu_hanh) {
        this.he_dieu_hanh = he_dieu_hanh;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setBo_nho(String bo_nho) {
        this.bo_nho = bo_nho;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setKet_noi(String ket_noi) {
        this.ket_noi = ket_noi;
    }

    public void setPin_sac(String pin_sac) {
        this.pin_sac = pin_sac;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getBao_hanh() {
        return bao_hanh;
    }

    public void setBao_hanh(String bao_hanh) {
        this.bao_hanh = bao_hanh;
    }
    

    @Override
    public int compareTo(SanPham sp) {
       return this.ma_san_pham-sp.ma_san_pham;
    }
   
    
    
    
}
