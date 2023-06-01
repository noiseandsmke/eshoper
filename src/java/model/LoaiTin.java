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
public class LoaiTin {
    private int ma_loai_tin;
    private String ten_loai_tin;

    public LoaiTin() {
    }

    public LoaiTin(String ten_loai_tin) {
        this.ten_loai_tin = ten_loai_tin;
    }
    

    public LoaiTin(int ma_loai_tin, String ten_loai_tin) {
        this.ma_loai_tin = ma_loai_tin;
        this.ten_loai_tin = ten_loai_tin;
    }

    public int getMa_loai_tin() {
        return ma_loai_tin;
    }

    public void setMa_loai_tin(int ma_loai_tin) {
        this.ma_loai_tin = ma_loai_tin;
    }

    public String getTen_loai_tin() {
        return ten_loai_tin;
    }

    public void setTen_loai_tin(String ten_loai_tin) {
        this.ten_loai_tin = ten_loai_tin;
    }
    
}
