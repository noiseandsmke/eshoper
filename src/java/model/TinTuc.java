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
public class TinTuc {

    private int ma_tin_tuc;
    private int ma_loai_tin;
    private String ten_tin_tuc;
    private String tieu_de;
    private String noi_dung;
    private String hinh_anh;
    private String ngay_dang;

    public TinTuc() {
    }

    public TinTuc(int ma_loai_tin, String ten_tin_tuc, String tieu_de, String noi_dung, String hinh_anh, String ngay_dang) {
        this.ma_loai_tin = ma_loai_tin;
        this.ten_tin_tuc = ten_tin_tuc;
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.hinh_anh = hinh_anh;
        this.ngay_dang = ngay_dang;
    }

    public TinTuc(int ma_tin_tuc, int ma_loai_tin, String ten_tin_tuc, String tieu_de, String noi_dung, String hinh_anh, String ngay_dang) {
        this.ma_tin_tuc = ma_tin_tuc;
        this.ma_loai_tin = ma_loai_tin;
        this.ten_tin_tuc = ten_tin_tuc;
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.hinh_anh = hinh_anh;
        this.ngay_dang = ngay_dang;
    }

    public int getMa_tin_tuc() {
        return ma_tin_tuc;
    }

    public void setMa_tin_tuc(int ma_tin_tuc) {
        this.ma_tin_tuc = ma_tin_tuc;
    }

    public int getMa_loai_tin() {
        return ma_loai_tin;
    }

    public void setMa_loai_tin(int ma_loai_tin) {
        this.ma_loai_tin = ma_loai_tin;
    }

    public String getTen_tin_tuc() {
        return ten_tin_tuc;
    }

    public void setTen_tin_tuc(String ten_tin_tuc) {
        this.ten_tin_tuc = ten_tin_tuc;
    }

    public String getTieu_de() {
        return tieu_de;
    }

    public void setTieu_de(String tieu_de) {
        this.tieu_de = tieu_de;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }

    public String getNgay_dang() {
        return ngay_dang;
    }

    public void setNgay_dang(String ngay_dang) {
        this.ngay_dang = ngay_dang;
    }

   

}
