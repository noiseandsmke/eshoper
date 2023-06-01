/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.SanPham;
import model.Value;

/**
 *
 * @author Nguyen
 */
public class ThongKeDAOImpl implements  ThongKeDAO{

    @Override
    public ArrayList<Value> getAll() {
         SanPhamDAOImpl spDao= new SanPhamDAOImpl();
        ArrayList<Value> list= new ArrayList<>();
        for(SanPham sp :spDao.getListSanPhamBanChay() )
        {
            list.add(new Value(sp.getTen_san_pham(),sp.getSo_luong()));
        }
        return list;
    }
    public static void main(String[] args) {
        ThongKeDAOImpl tk= new ThongKeDAOImpl();
       // System.out.println( tk.getAll() );
         for(Value v: tk.getAll())
         {
             System.out.println(v.getName() + "-"+ v.getValue());
         }
    }
}
