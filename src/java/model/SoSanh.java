/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.TreeMap;

/**
 *
 * @author Nguyen
 */
public class SoSanh {

    private TreeMap<SanPham, Integer> listcompare;
    private long compareID;

    public SoSanh() {
        listcompare = new TreeMap<>();
        compareID = System.currentTimeMillis();
    }

    public SoSanh(TreeMap<SanPham, Integer> listcompare, long compareID) {
        this.listcompare = listcompare;
        this.compareID = compareID;
    }

    public TreeMap<SanPham, Integer> getListcompare() {
        return listcompare;
    }

    public void setListcompare(TreeMap<SanPham, Integer> listcompare) {
        this.listcompare = listcompare;
    }

    public long getCompareID() {
        return compareID;
    }

    public void setCompareID(long compareID) {
        this.compareID = compareID;
    }

    public void addToCompare(SanPham sp) {
        listcompare.put(sp, 1);
    }

    public void removeToCompare(SanPham sp) {
        boolean bln = listcompare.containsKey(sp);
        if (bln) {
            listcompare.remove(sp);

        }
    }

}
