/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ChiTietHoaDonDAOImpl;
import dao.DanhMucDAOImpl;
import dao.SanPhamDAOImpl;
import dao.TaiKhoanDAOImpl;
import dao.TinTucDAOImpl;
import model.DanhMuc;
import model.SanPham;
import model.TaiKhoan;
import model.TinTuc;

/**
 *
 * @author Nguyen
 */
public class Main {

    public static void main(String[] args) {
        DanhMucDAOImpl dm = new DanhMucDAOImpl();
        
    
        SanPhamDAOImpl spDao = new SanPhamDAOImpl();
        TinTucDAOImpl tinTucDAO= new TinTucDAOImpl();
        //System.out.println(sp.getListSanPhamTheoDanhMuc("1").size());
        //System.out.println(sp.getChiTietSanPham("1").getTen_san_pham()+"-"+sp.getChiTietSanPham("1").getDon_gia());
        TaiKhoanDAOImpl tk = new TaiKhoanDAOImpl();
        // System.out.println(tk.getListTaiKhoang("abc").size() );
        //System.out.println(tk.kiemTraTaiKhoan("anhduoc2705195@gmail.com"));
        ChiTietHoaDonDAOImpl chiTietHoaDon = new ChiTietHoaDonDAOImpl();
//        for(TaiKhoan c: tk.getListTaiKhoan("a"))
//        {
//            System.out.println(c.getTen_dang_nhap() +"- "+c.getMat_khau());
//            
//        }
//        for (SanPham sp : spDao.getListSanPhamMoi()) {
//            System.out.println(sp.getMa_san_pham()+"-"+sp.getTen_san_pham() + "- "+ sp.getDon_gia());
//
//        }
//          for(SanPham sp: spDao.getListSanPhamTheoGia(0, 5000000))
//          {
//              System.out.println(sp.getTen_san_pham()+ "-"+ sp.getDon_gia());
//          }
            for(TinTuc tt :tinTucDAO.getListTinTuc())
            {
                System.out.println(tt.getTen_tin_tuc()+ "-"+tt.getHinh_anh()+"-" +tt.getNoi_dung());
            }
           // System.out.println(tinTucDAO.getListTinTucTheoMa(1).getMa_tin_tuc()+"-"+tinTucDAO.getListTinTucTheoMa(1).getNoi_dung());
           //dm.insertDanhMuc(new DanhMuc("abc", "ten_danh_muc", "danh_muc_cha"));
           // System.out.println("insert thanh cong");
            //dm.updateDanhMuc(new DanhMuc("abc", "ten_danh_muc1", "danh_muc_cha1"));
            //System.out.println("update thanh cong");
          // dm.deleteDanhMuc(9);
          // System.out.println("xong !");
        
  
//        dm.getDanhMuc(1);
//        System.out.println(dm.getDanhMuc(1).getTen_danh_muc());
//dm.updateDanhMuc(new DanhMuc(11,"abc"));
       // System.out.println("update thanh cong");
    
//  
//spDao.updateSanPham(new SanPham(15, "ten_san_pham1", 1, "hinh_anh1", 1, 1, 1, "man_hinh1", "camera_sau1", "camera_truoc1", "he_dieu_hanh", "cpu", "bo_nho1", "ram1", "ket_noi1", "pin_sac", "mo_ta"));
      //  System.out.println("update thanh cong !");
     // spDao.deleteSanPham(15);
    }
}
