/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Map;
import Model.MonAn;
import java.util.Date;
import java.util.HashMap;
/**
 *
 * @author anhtu
 */
public class SuatAn {
    int MaSuatAn;
    boolean sanSang;
    int tongTien;
    Date thoiGian;
    Map<String, MonAn> ds;
    
    //Khoi tao
    public SuatAn() {
        sanSang = false;
        thoiGian = new Date();
    }

    public SuatAn(int MaSuatAn, boolean sanSang, int tongTien, Date thoiGian, Map<String, MonAn> ds) {
        this.MaSuatAn = MaSuatAn;
        this.sanSang = sanSang;
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
        this.ds = ds;
    }

    //Get Set

    public boolean getSanSang() {
        return sanSang;
    }

    public void setSanSang(boolean sanSang) {
        this.sanSang = sanSang;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }
    
    public void setThoiGian(Date thoiGian) {    
        this.thoiGian = thoiGian;
    }

    public int getMaSuatAn() {
        return MaSuatAn;
    }

    public void setMaSuatAn(int MaSuatAn) {
        this.MaSuatAn = MaSuatAn;
    }

    public Map<String, MonAn> getDs() {
        return ds;
    }

    public void setDs(Map<String, MonAn> ds) {
        this.ds = ds;
    }
    
    //Them, Xoa, Thuc Hien Suat An
    public void capNhatMonAn(MonAn monAn) {
        for(String key : ds.keySet()){
            if(key == monAn.getMaMon()){
                this.ds.remove(key);
            }
            this.ds.put(key, monAn);
            break;
        }
    }
    
    public void xoaMonAn(MonAn monAn) {
        for(String key : ds.keySet()){
            if(key == monAn.getMaMon()){
                this.ds.remove(key);
                break;
            }
        }
    }
    
    public boolean make(){
        for (Map.Entry<String, MonAn> entry : ds.entrySet()) {
            String key = entry.getKey();
            MonAn val = entry.getValue();
            if(!val.make()){
                return false;
            }
        }
        this.sanSang = true;
        return true;
    }
    
    public void tongTien(){
        int sum = 0;
        for (Map.Entry<String, MonAn> entry : ds.entrySet()) {
            String key = entry.getKey();
            MonAn val = entry.getValue();
            sum += val.getDongia() * val.getSoLuong();
        }
        this.tongTien = sum;
    }
}
