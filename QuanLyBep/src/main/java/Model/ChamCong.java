package Model;
import java.sql.Date;
public class ChamCong {
    private String maNV;
    private int soGioLam;
    private double luongTheoGio;
    private Date ngayLam;
    
    public ChamCong(){
        
    }

    public ChamCong(String maNV, int soGioLam, double luongTheoGio, Date ngayLam) {
        this.maNV = maNV;
        this.soGioLam = soGioLam;
        this.luongTheoGio = luongTheoGio;
        this.ngayLam = ngayLam;
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
