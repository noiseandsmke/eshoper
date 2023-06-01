/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.TinTuc;

/**
 *
 * @author Nguyen
 */
public interface TinTucDAO {

    public ArrayList<TinTuc> getListTinTuc();

    public ArrayList<TinTuc> getListTinTucTheoLoaiTin(int ma_loai_tin);

    public TinTuc getListTinTucTheoMa(int ma_tin_tuc);

    public ArrayList<TinTuc> getListTinTucMoi();

    public boolean insertTinTuc(TinTuc tintuc);

    public boolean updateTinTuc(TinTuc tintuc);

    public boolean deleteTinTuc(int ma_tin_tuc);

    public ArrayList<TinTuc> getListTinTucTheoTrang(ArrayList<TinTuc> arr, int start, int end);
    
    public boolean  deleteTinTucTheoMaLoaiTin(int ma_loai_tin);

}
