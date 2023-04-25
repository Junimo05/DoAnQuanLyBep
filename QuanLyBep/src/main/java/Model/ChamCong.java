package Model;
import java.sql.Date;
public class ChamCong {
    private Date ngayLam;
    private int soGioLam;
    private double luongTheoGio;
    private String maNV;
    
    public ChamCong(){
        
    }
    
    public ChamCong(int  soGioLam, Date ngayLam, String maNV){
            this.soGioLam = soGioLam;
            this.ngayLam = ngayLam;
            this.maNV = maNV;
    }

    //Get Set()
    public void setgioLam(int soGioLam){
            this.soGioLam = soGioLam;
    }
    public int getgioLam(){
            return soGioLam;
    }
    public void setngayLam(Date ngayLam){
            this.ngayLam = ngayLam;
    }
    public Date getngayLam(){
            return ngayLam;
    }
    public void setmaNV(String maNV){
            this.maNV = maNV;
    }
    public String getmaNV() {
            return maNV;
    }
    public double getLuongTheoGio() {
        return luongTheoGio;
    }

    public void setLuongTheoGio(double luongTheoGio) {
        this.luongTheoGio = luongTheoGio;
    }
        
}
