/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Model.ChamCong;
import Model.MonAn;
import Model.NguyenLieu;
import Model.SuatAn;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    public boolean MakeSA(SuatAn SA){
        if(SA.getSanSang() != true){
            if(SA.make()){
                return new SuatAnDAO().UpdateSA(SA);
            }else{
                JOptionPane.showMessageDialog(null, "Kiểm Tra Lại Số Lượng Nguyên Liệu", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Suất Ăn Đã Được Làm", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            SA.tinh_loiNhuan();
            new SuatAnDAO().UpdateSA(SA);
        }
        return false;
    }
    
    public void UpdateNL(ArrayList<NguyenLieu> ds){
        for(NguyenLieu nl : ds){
            new NguyenLieuDAO().CapNhatNguyenLieu(nl);
        }
    }

    public void UpdateSA(int MaSA){
        for(SuatAn SA : DSSA){
            if(SA.getMaSuatAn() == MaSA){
                SA.tongTien();
                new SuatAnDAO().UpdateSA(SA);
            }
        }
    }
    
    /*
    *   Cập nhật Chấm Công
    */
    public boolean UpdateChamCong(String id){
        String timeIn = new DataHomePageDAO().getTimeIn(id);
        String timeOut = new DataHomePageDAO().getTimeOut(id);
        String timeBackup = timeOut;
        //So Gio Lam
        // Parse chuỗi timeIn và timeOut thành đối tượng LocalTime
        timeIn = timeIn.substring(11);
        timeOut = timeOut.substring(11);
        LocalTime inTime = LocalTime.parse(timeIn);
        LocalTime outTime = LocalTime.parse(timeOut);

        // Tính số giờ làm việc
        Duration duration = Duration.between(inTime, outTime);
        long hoursWorked = duration.toHours();

        // Làm tròn số giờ làm việc đến giờ gần nhất
        hoursWorked = Math.round(hoursWorked);
        int hoursAsInt = Math.toIntExact(hoursWorked);
        
        //Luong
        float luong = 0;
        if(hoursAsInt < 1){
            luong = 0;
        }else if(hoursAsInt <= 4){
            luong = 19000;
        }else if(hoursAsInt > 4 && hoursAsInt < 8){
            luong = 21000;
        }else if(hoursAsInt > 8){
            luong = 23000;
        }
        
        //Date
        LocalDate date = LocalDate.parse(timeBackup.substring(0, 10));
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        
        ChamCong cc = new ChamCong(id, hoursAsInt, luong, sqlDate);
        return new NhanVienDAO().addChamCong(cc);
    }
}
