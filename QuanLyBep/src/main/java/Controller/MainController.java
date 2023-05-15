/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Model.MonAn;
import Model.NguyenLieu;
import Model.SuatAn;
import java.util.ArrayList;

/**
 *
 * @author anhtu
 */
public class MainController {
    private ArrayList<SuatAn> DSSA = new SuatAnDAO().getListSA();
    private ArrayList<MonAn> DSMA = new MonAnDAO().getListMA();
    private ArrayList<NguyenLieu> DSNL = new NguyenLieuDAO().getListNL();
    
    /*
    *   Sự Kiện phục vụ yêu cầu thực hiện món ăn
    */
    public boolean  MakeSA(SuatAn SA){
        if(SA.make()){
            if(new SuatAnDAO().UpdateSA(SA)) return true;
            else return false;
        }
        return false;
    }
    
    public void UpdateNL(ArrayList<NguyenLieu> ds){
        for(NguyenLieu nl : ds){
            new NguyenLieuDAO().CapNhatNguyenLieu(nl);
        }
    }
    
    /*
    *   Sự Kiện Cập Nhật Món Ăn
    */
    
    
}
