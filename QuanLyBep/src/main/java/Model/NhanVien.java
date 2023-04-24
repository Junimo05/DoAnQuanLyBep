package Model;
import java.util.Date;

public class NhanVien {
	private String tenNV;
	private int maNV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private double luong;
	private String sodienThoai;
	public NhanVien(int maNV, String tenNV, Date ngaySinh, boolean gioiTinh, double luong, String sodienThoai) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
        // Get Set()	
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public double getluong(){
		return luong;
	}
	public void setluong(double luong){
		this.luong = luong;
	}
	public String getsodienThoai(){
		return sodienThoai;
	}
	public void setsodienThoai(String sodienThoai){
		this.sodienThoai = sodienThoai;
	}
        
        //Hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (gioiTinh ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(luong);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + maNV;
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((sodienThoai == null) ? 0 : sodienThoai.hashCode());
		result = prime * result + ((tenNV == null) ? 0 : tenNV.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "NhanVien [tenNV=" + tenNV + ", maNV=" + maNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", luong=" + luong + ", sodienThoai=" + sodienThoai + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (gioiTinh != other.gioiTinh)
			return false;
		if (Double.doubleToLongBits(luong) != Double.doubleToLongBits(other.luong))
			return false;
		if (maNV != other.maNV)
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (sodienThoai == null) {
			if (other.sodienThoai != null)
				return false;
		} else if (!sodienThoai.equals(other.sodienThoai))
			return false;
		if (tenNV == null) {
			if (other.tenNV != null)
				return false;
		} else if (!tenNV.equals(other.tenNV))
			return false;
		return true;
	}
}
	