/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.LoaiTin;

/**
 *
 * @author Nguyen
 */
public interface LoaiTinDAO {
    public ArrayList<LoaiTin> getListLoaiTin();
    public LoaiTin getLoaiTin(int ma_loai_tin);
    boolean insertLoaiTin(LoaiTin loaitin);
    boolean updateLoaiTin(LoaiTin loaitin);
    boolean deleteLoaiTin(int ma_loai_tin);
    public ArrayList<LoaiTin> getListLoaiTinTheoTrang(ArrayList<LoaiTin> arr, int start, int end);
    
}
