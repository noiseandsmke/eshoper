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
public class DanhMuc {

    private int ma_danh_muc;
    private String ten_danh_muc;

    public DanhMuc() {
    }

    public DanhMuc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
    

    public DanhMuc(int ma_danh_muc, String ten_danh_muc) {
        this.ma_danh_muc = ma_danh_muc;
        this.ten_danh_muc = ten_danh_muc;
    }

    public int getMa_danh_muc() {
        return ma_danh_muc;
    }

    public void setMa_danh_muc(int ma_danh_muc) {
        this.ma_danh_muc = ma_danh_muc;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }


   
    

}
