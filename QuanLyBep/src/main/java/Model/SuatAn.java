/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Map;
import Model.MonAn;
import java.util.HashMap;
/**
 *
 * @author anhtu
 */
public class SuatAn {
    int MaSuatAn;
    boolean sanSang;
    Map<MonAn, Integer> ds;
    
    //Khoi tao
    public SuatAn() {
    }
    
    public SuatAn(int MaSuatAn){
        this.MaSuatAn = MaSuatAn;
        this.sanSang = false;
        this.ds = new HashMap<MonAn, Integer>();
    }
    
    public SuatAn(int MaSuatAn, boolean sanSang, Map<MonAn, Integer> ds) {
        this.MaSuatAn = MaSuatAn;
        this.sanSang = sanSang;
        this.ds = ds;
    }
    
    //Get Set
    public int getMaSuatAn() {
        return MaSuatAn;
    }

    public void setMaSuatAn(int MaSuatAn) {
        this.MaSuatAn = MaSuatAn;
    }

    public Map<MonAn, Integer> getDs() {
        return ds;
    }

    public void setDs(Map<MonAn, Integer> ds) {
        this.ds = ds;
    }
    
    //Them, Xoa, Thuc Hien Suat An
    public void capNhatMonAn(MonAn monAn, int soLuong) {
        ds.put(monAn,soLuong);
    }
    
    public void xoaMonAn(MonAn monAn, int soLuongCanXoa) {
        if (ds.containsKey(monAn)) {
            int soLuongHienTai = ds.get(monAn); 
                ds.remove(monAn);                      
        } else {
            // Nếu món ăn không tồn tại trong Map, thông báo lỗi
            throw new IllegalArgumentException("Món ăn không tồn tại trong suất ăn!");
        }
    }
    
    public boolean make(){
        for (Map.Entry<MonAn, Integer> entry : ds.entrySet()) {
            MonAn key = entry.getKey();
            int val = entry.getValue();
            for(int i = 0; i < val; i++){
                if(!key.make()) return false;
            }
        }
        sanSang = true;
        return true;
    }
}
