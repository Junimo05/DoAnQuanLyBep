package Model;
import java.sql.Date;
import java.sql.Timestamp;
public class ChamCong {
	private Date ngayLam;
	private int soGioLam;
	private int maNV;
	public ChamCong(int  soGioLam, Date ngayLam, int maNV){
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
	public void setmaNV(int maNV){
		this.maNV = maNV;
	}
	public int getmaNV() {
		return maNV;
	}

}
