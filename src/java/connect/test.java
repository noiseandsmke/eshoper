/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import dao.LoaiTinDAOImpl;
import java.util.ArrayList;
import model.LoaiTin;

/**
 *
 * @author caiho
 */
public class test {
        public static void main(String[] args) {
        LoaiTinDAOImpl impl = new LoaiTinDAOImpl();
        ArrayList<LoaiTin> loaitins = impl.getListLoaiTin();
        System.out.println(loaitins.toString());
    }
}
